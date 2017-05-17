require 'grpc'

require_relative 'application_pb'
require_relative 'application_services_pb'

require_relative 'messages/Combat_pb'
require_relative 'messages/Dice_pb'
require_relative 'messages/Hero_pb'
require_relative 'messages/Monster_pb'

$hero_list = []
$hero_list << Hero.new(id: 0,
											name: 'Frodo',
											strength: 1,
											resistance: 20,
											health: 10)
$hero_list << Hero.new(id: 1,
											name: 'Aragorn',
											strength: 4,
											resistance: 17,
											health: 18)
$hero_list << Hero.new(id: 2,
											name: 'Legolas',
											strength: 4,
											resistance: 19,
											health: 15)
$hero_list << Hero.new(id: 3,
											name: 'Gandalf',
											strength: 20,
											resistance: 14,
											health: 15)
$hero_list << Hero.new(id: 4,
											name: 'Gimli',
											strength: 10,
											resistance: 19,
											health: 20)
$hero_list << Hero.new(id: 666,
											name: 'Chuck Norris',
											strength: 99999,
											resistance: 99999,
											health: 99999)

class RubyServer < RubyInterface::Service
	def get_hero(heroId_req, _unused_call)
			return $hero_list.select{|h| h.id == heroId_req.id}.first
	end
end

$monster_list = []
$javaStub = nil
$pythonStub = nil

def printMenu()
	puts "Numero de Heroes = [#{$hero_list.length}]"
	puts "Numero de Monsters = [#{$monster_list.length}]"
	puts "RubyApp Menu:"
	puts "py-monster \t\t\t Selecionar um monster"
	puts "java-dice \t\t\t Jogar um dado"
	puts "java-combat \t\t\t Realizar um Combate"
	puts "sm \t\t\t\t listar monsters"
	puts "sh \t\t\t\t listar heroes"
	puts "q \t\t\t\t Sair"
end

def switchOP(op)
	if op == 'py-monster'
		print "Digite o ID do monstro(-1 para aleatório): "
		mId = MonsterId.new(id: Integer(gets.chomp))
		$monster_list << $pythonStub.generate_monster(mId)

	elsif op == 'java-dice'
		print "Tipo do dado (D4,D6,D8,D10,D12,D20,D100):"
		diceType = DiceType.new(tipoDado: gets.chomp.to_sym)
		rolledDice = $javaStub.roll_dice(diceType)
		puts "O dado rolou #{rolledDice.rolledNumber}"

	elsif op == 'java-combat'
		print "Entre o id do hero: "
		id = Integer(gets.chomp)
		hero = $hero_list.select{|h| h.id == heroId_req.id}.first
		monster = monster_list[rand(monster_list.length)]

		combat = Combat.new(atk_strength: hero.strength,
												atk_resistance: hero.resistance,
												atk_health: hero.health,
												def_strength: monster.strength,
												def_resistance: monster.resistance,
												def_health: monster.health)
		puts "\n\n #{hero.name} VS #{monster.name}"
		combat = $javaStub.calculate_combat(combat)
		if combat.who_won == :Defender
			puts "\nVencedor: #{monster.name}"
		else
			puts "\nVencedor: #{hero.name}"
		end

	elsif op == 'sm'
		$monster_list.each { |m| puts "#######"
														 puts "id: #{m.id}"
													   puts "name: #{m.name}"
													 	 puts "str: #{m.strength}"
													   puts "res: #{m.resistance}"
													   puts "health: #{m.health}" }
		puts "#######"

	elsif op == 'sh'
		$hero_list.each { |m| puts "#######"
													puts "id: #{m.id}"
													puts "name: #{m.name}"
													puts "str: #{m.strength}"
													puts "res: #{m.resistance}"
													puts "health: #{m.health}" }
		puts "#######"

	elsif op == 'q'
		return :die
	end
end

def main
	th_server = Thread.new{
		server = GRPC::RpcServer.new
		server.add_http2_port('0.0.0.0:50051',:this_port_is_insecure)
		server.handle(RubyServer)
		server.run_till_terminated
	}

	print "Digite o IP da máquina JAVA: "
	javaIp = gets.chomp
	javaIp += ':50051'
	$javaStub = JavaInterface::Stub.new(javaIp,:this_channel_is_insecure)

	print "Digite o IP da máquina PYTHON: "
	pythonIp = gets.chomp
	pythonIp += ':50051'
	$pythonStub = PythonInterface::Stub.new(pythonIp,:this_channel_is_insecure)

	op = ''
	while op != "q"
		printMenu
		if switchOP(gets.chomp) == :die
			break
		end
	end

	# Finalizando a execução da thread
	if th_server.alive?
		Thread.kill(th_server)
		th_server.join
	end
end

main
