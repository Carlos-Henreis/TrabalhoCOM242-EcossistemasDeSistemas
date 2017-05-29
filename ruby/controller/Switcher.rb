require_relative '../interfaces/application_services_pb'
require_relative '../server/RubyApp'
require_relative '../messages/Dice_pb'
require_relative '../messages/Monster_pb'
require_relative '../messages/Combat_pb'

class Switcher
	@port = ':50051'
	def jvip
		print 'Digite o IP da máquina JAVA: '
		$javaIP = gets.chomp
		$javaIP += @port
		$javaStub = JavaInterface::Stub.new($javaIp,:this_channel_is_insecure)
	end
	
	def pyip
		print 'Digite o IP da máquina PYTHON: '
		$pythonIP = gets.chomp
		$pythonIP += @port
		$pythonStub = JavaInterface::Stub.new($pythonIp,:this_channel_is_insecure)
	end
	
	def rh		
		h = Hero.new
		print 'Digite o ID do hero: '
		h.id = gets.chomp
		print 'Digite o nome do hero: '
		h.name = gets.chomp
		print 'Digite a força do hero: '
		h.strength = gets.chomp 
		print 'Digite a resistência do hero: '
		h.resistance = gets.chomp
		print 'Digite a vida do hero: '
		h_hp = gets.chomp
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
		dice_type = DiceType.new(tipoDado: t.capitalize)

		rolledDice = $javaStub.rollDice(dice_type)
		puts '\n\nO dado rolou: #{rolledDice.rolledNumber}'
	end
	
	def sc
		if $javaStub == nil or $pythonStub
			puts 'Defina o IP da máquina Java e Python'
			return
		end 
		print 'Chame seus herois!\n Digite o Id ou -1 para todos:'
		hID = HeroID.new(id: gets.chomp)
		heroes = RubyApp.new.self_get_hero(hID)

		print 'Quantidade de monstros: '
		mons = $pythonStub.selfGenerateMonsters(MonsterQt.new(qt: gets.chomp))
		c = Combat.new

		while not mons.empty? 
			puts 'Seus adversários\n#########'
			mons.each{|m| puts "#{m.id} #{m.name} #{m.health}/#{m.maxHealth}"}
			puts '#########'

			puts '\nSua equipe\n#########'
			heroes.each{|h| puts "#{h.id} #{h.name} #{h.health}/#{h.maxHealth}"}
			puts '#########'

			atk = nil
			print 'Digite o id do heroi atacante: '
			n = gets.chomp
			atk = heroes.select{|h| h.id == n}.first
			if atk == nil
				abort('Id inválido')
			end

			defender = nil
			print 'Digite o id do monstro: ' 
			n = gets.chomp
			defender = mons.select{|m| m.id == n}.first
			if defender == nil
				abort('Id inválido')
			end

			c.aHero = atk
			c.aMonster = defender
			c.who_attacks = :hero

			c = $javaStub.calculateCombat(c)
			mons.map!{|m| 
				if m.id == defender.id
					m = defender
					break
				end}
			mons.delete_if{ |m| m.health == 0}

			if c.who_attacks == :hero
				atk = c.aHero
				RubyApp.new.this_set_hero(atk)
				heroes = RubyApp.new.self_get_hero(hID)
			end
			if c.deadDefender == false
				print 'O monstro não foi derrotado, ele ira atacar'
				c.who_attacks = :monster
				$javaStub.calculateCombat(c)
			else 
				print "Monstro #{defender.name} foi derrotado"
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
