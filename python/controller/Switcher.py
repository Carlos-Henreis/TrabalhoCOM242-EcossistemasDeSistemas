from messages.Hero_pb2 import *
from messages.Monster_pb2 import *
from messages.Combat_pb2 import *
from server.PythonApp import *
from messages import Dice_pb2 as dice_pkg

from interfaces import application_pb2_grpc as app_grpc

port = ':50051'

globals()['javaStub'] = None
globals()['rubyStub'] = None
globals()['javaIP'] = None
globals()['rubyIP'] = None

def switch_op(op):
	if (op == 'jvip'):
		globals()['javaIP'] = input('Digite o IP da máquina JAVA: ')
		globals()['javaIP'] += port
		channel = grpc.insecure_channel(globals()['javaIP'])
		globals()['javaStub'] = app_grpc.javaInterfaceStub(channel)
	elif (op == 'rbip'):
		globals()['rubyIP'] = input('Digite o IP da máquina RUBY: ')
		globals()['rubyIP'] += ':50053'
		channel = grpc.insecure_channel(globals()['rubyIP'])
		globals()['rubyStub'] = app_grpc.rubyInterfaceStub(channel)
	elif(op == 'rh'):
		if(globals()['rubyStub'] == None):
			print('Defina o IP da máquina Ruby')
			return
		h = Hero()
		h.id = int(input('Digite o ID do hero: '))
		h.name = input('Digite o nome do hero: ')
		h.strength = int(input('Digite a força do hero: '))
		h.resistance = int(input('Digite a resistência do hero: '))
		h_hp = int(input('Digite a vida do hero: '))
		h.health = h_hp
		h.maxHealth = h_hp
		try:
			h_list = globals()['rubyStub'].addHero(h)
			print('Um heroi se juntou a equipe!')
			for hero in h_list.hero:
				print('\nid: '+str(hero.id))
				print('name: '+hero.name)
				print('str: '+str(hero.strength))
				print('res: '+str(hero.resistance))
				print('hp: '+str(hero.health)+'/'+str(hero.maxHealth))
		except Exception as e:
			print(e)
		
		
	elif(op == 'rd'):

		if(globals()['javaStub'] == None):
			print('Defina o IP da máquina Java')
			return

		t = input('Tipo do dado (D4,D6,D8,D10,D12,D20,D100):')
		dice_type = dice_pkg.DiceType(tipoDado=t.upper())

		rolledDice = globals()['javaStub'].rollDice(dice_type)
		print('\n\nO dado rolou: '+str(rolledDice.rolledNumber))

	elif(op == 'sc'):
		if(globals()['javaStub'] == None):
			print('Defina o IP da máquina Java')
			return

		call = int(input("Chame seus herois!\n Digite o Id ou -1 para todos:"))

		hID = HeroID()
		hID.id = call

		try:
			hero_list = globals()['rubyStub'].getHero(hID)
		except Exception as e:
			print(e)
			return		

		n = int(input("Quantidade de monstros: "))
		mQt = MonsterQt()
		mQt.qt = n
		
		mons = PythonApp().selfGenerateMonster(mQt)
		c = Combat()

		while len(mons.monster) and len(hero_list.hero):
			print('Seus adversários\n#########')
			for monster in mons.monster:
				print("%i %s %i" %(monster.id, monster.name, monster.health))
			print('#########')

			print('\nSua equipe\n#########')
			for hero in hero_list.hero:
				print("%i %s %i/%i" %(hero.id, hero.name, hero.health, hero.maxHealth))
			print('#########')

			n = int(input('Digite o id do heroi atacante: '))
			atk = None
			for hero in hero_list.hero:
				if (hero.id == n):
					atk = hero
					break
			if(atk == None):
				print('ID inválido')
				sys.exit(1)

			n = int(input('Digite o id do monstro: '))
			defender = None
			for monster in mons.monster:
				if (monster.id == n):
					defender = monster
					break
			if(defender == None):
				sys.exit(1)

			c.aHero.CopyFrom(atk)
			c.aMonster.CopyFrom(defender)
			c.who_attacks = 0
			try:
				c = globals()['javaStub'].calculateCombat(c)	
			except Exception as e:
				print(e)
			
			
			for monster in mons.monster:
				if(monster.id == c.aMonster.id):
					monster.health = c.aMonster.health
				if(monster.health <= 0):
					mons.monster.remove(monster)

			if (c.deadDefender == False):
				print('O monstro não foi derrotado, ele ira atacar')
				c.who_attacks = 1
				try:
					c = globals()['javaStub'].calculateCombat(c)	
					hero_list = globals()['rubyStub'].setHero(c.aHero)
				except Exception as e:
					print(e)
							
				if c.deadDefender == True :
					print("O herói %s foi morto!" %(c.aHero.name))
			else: 
				print("Monstro %s foi derrotado" %(defender.name))
				
	elif(op == 'sh'):
		if(globals()['rubyStub'] == None):
			print('Defina o IP da máquina Ruby')
			return
		hId = HeroID()
		hId.id = -1
		try:
			heroes = globals()['rubyStub'].getHero(hId)
			heroes = globals()['rubyStub'].getHero(hId)
			for hero in heroes.hero:
				print('#######')
				print('id: ' + str(hero.id))
				print('name: ' + hero.name)
				print('str: ' + str(hero.strength))
				print('res: ' + str(hero.resistance))
				print('health: '+ str(hero.health) + '/' + str(hero.maxHealth))
			print('#######')
		except Exception as e:
			print(e)
		
		
		
