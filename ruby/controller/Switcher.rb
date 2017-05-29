require_relative '../interfaces/application_services_pb'
require_relative '../server/RubyApp'
require_relative '../messages/Dice_pb'
require_relative '../messages/Monster_pb'
require_relative '../messages/Combat_pb'

$port = ':50051'
$javaStub = nil
$javaIp = nil
$pythonStub = nil
$pythonIp = nil

class Switcher
	def jvip
		print 'Digite o IP da máquina JAVA: '
		$javaIp = gets.chomp
		$javaIp += $port
		$javaStub = JavaInterface::Stub.new($javaIp,:this_channel_is_insecure)
	end

	def pyip
		print 'Digite o IP da máquina PYTHON: '
		$pythonIp = gets.chomp
		$pythonIp += ':50052'
		$pythonStub = PythonInterface::Stub.new($pythonIp,:this_channel_is_insecure)
	end

	def rh
		h = Hero.new
		print 'Digite o ID do hero: '
		h.id = gets.chomp.to_i
		print 'Digite o nome do hero: '
		h.name = gets.chomp
		print 'Digite a força do hero: '
		h.strength = gets.chomp.to_i
		print 'Digite a resistência do hero: '
		h.resistance = gets.chomp.to_i
		print 'Digite a vida do hero: '
		h_hp = gets.chomp.to_i
		h.health = h_hp
		h.maxHealth = h_hp

		RubyApp.new.self_add_hero(h)
		puts 'Um heroi se juntou a equipe! '
		$hero_list.each{|h| puts "\nid: #{h.id}"
							puts "name: #{h.name}"
							puts "str: #{h.strength}"
							puts "res: #{h.resistance}"
							puts "hp: #{h.health}/#{h.maxHealth}"}
	end

	def rd
		if $javaStub == nil
			puts 'Defina o IP da máquina Java'
			return
		end
		print 'Tipo do dado (D4,D6,D8,D10,D12,D20,D100):'
		t = gets.chomp
		dice_type = DiceType.new(tipoDado: t.capitalize.to_sym)
		puts $javaStub.class.name
		rolledDice = $javaStub.roll_dice(dice_type)
		puts "\n\nO dado rolou: #{rolledDice.rolledNumber}"
	end

	def sc
		if $javaStub == nil or $pythonStub == nil
			puts 'Defina o IP da máquina Java e Python'
			return
		end
		print 'Chame seus herois!\n Digite o Id ou -1 para todos:'
		hID = HeroID.new(id: gets.chomp.to_i)
		heroes = RubyApp.new.self_get_hero(hID)


		print 'Quantidade de monstros: '
		mons = $pythonStub.generate_monster(MonsterQt.new(qt: gets.chomp.to_i))
		c = Combat.new
		mons = mons.monster.to_a

		while (not mons.empty?) and (not heroes.empty?)
			puts heroes.inspect
			puts heroes.length
			puts "Seus adversários\n#########"
			mons.each{|m| puts "#{m.id} #{m.name} #{m.health}"}
			puts '#########'

			puts "\nSua equipe\n#########"
			heroes.each{|h| puts "#{h.id} #{h.name} #{h.health}/#{h.maxHealth}"}
			puts '#########'

			print 'Digite o id do heroi atacante: '
			n = gets.chomp.to_i
			atk = heroes.select{|h| h.id == n}.first
			if atk == nil
				abort('Id inválido')
			end

			print 'Digite o id do monstro: '
			n = gets.chomp.to_i
			defender = mons.select{|m| m.id == n}.first
			if defender == nil
				abort('Id inválido')
			end

			c.aHero = atk
			c.aMonster = defender
			c.who_attacks = :Hero.to_sym
			c.deadDefender = false

			c = $javaStub.calculate_combat(c)
			mons.map!{|m| (m.id == defender.id) ? c.aMonster : m }
				mons.compact!
			mons.delete_if{ |m| m.health <= 0}


			if c.who_attacks == :Hero.to_sym
				atk = c.aHero
				RubyApp.new.self_set_hero(atk)
				heroes = RubyApp.new.self_get_hero(hID)
			end
			if c.deadDefender == false
				puts 'O monstro não foi derrotado, ele ira atacar'
				c.who_attacks = :Monster.to_sym
				c = $javaStub.calculate_combat(c)

				RubyApp.new.self_set_hero(c.aHero)
				heroes = RubyApp.new.self_get_hero(hID)
				if (heroes.length == 0)
					puts 'Os heros foram derrotados'
				end
			else
				puts "Monstro #{defender.name} foi derrotado"
			end
		end
	end

	def sh
		$hero_list.each{ |h|
			puts '#######'
			puts "id: #{h.id}"
			puts "name: #{h.name}"
			puts "str: #{h.strength}"
			puts "res: #{h.resistance}"
			puts "health: #{h.health}/#{h.maxHealth}"}
		puts '#######'
	end

	def q
	    :die
	end
end
