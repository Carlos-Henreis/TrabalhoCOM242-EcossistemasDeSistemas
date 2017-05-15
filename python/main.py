from concurrent import futures

import grpc
import threading
import time

import application_pb2 as app
import application_pb2_grpc as app_grpc

from messages import Monster_pb2 as monster_pkg
from messages import Hero_pb2 as hero_pkg
from messages import Dice_pb2 as dice_pkg
from messages import Combat_pb2 as combat_pkg

from random import randrange

monster_list = []
monster_list.append(monster_pkg.Monster())
monster_list[0].id = 0
monster_list[0].name = 'goblin'
monster_list[0].strength = 1
monster_list[0].resistance = 16
monster_list[0].health = 5

monster_list.append(monster_pkg.Monster())
monster_list[1].id = 1
monster_list[1].name = 'orc'
monster_list[1].strength = 2
monster_list[1].resistance = 12
monster_list[1].health = 10

monster_list.append(monster_pkg.Monster())
monster_list[2].id = 2
monster_list[2].name = 'ogre'
monster_list[2].strength = 4
monster_list[2].resistance = 12
monster_list[2].health = 20

monster_list.append(monster_pkg.Monster())
monster_list[3].id = 3
monster_list[3].name = 'troll'
monster_list[3].strength = 4
monster_list[3].resistance = 16
monster_list[3].health = 30

monster_list.append(monster_pkg.Monster())
monster_list[4].id = 4
monster_list[4].name = 'beholder'
monster_list[4].strength = 6
monster_list[4].resistance = 15
monster_list[4].health = 20

monster_list.append(monster_pkg.Monster())
monster_list[5].id = 5
monster_list[5].name = 'dragon'
monster_list[5].strength = 10
monster_list[5].resistance = 20
monster_list[5].health = 40

class PythonApplication (app_grpc.pythonInterfaceServicer, threading.Thread):

	def __init__(self):
		threading.Thread.__init__(self)
		app_grpc.pythonInterfaceServicer.__init__(self)
		self._stop_event = threading.Event()

	def stop(self):
		self.server.stop(0)
		self._stop_event.set()

	def run(self):
		self.server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
		app_grpc.add_pythonInterfaceServicer_to_server(self,self.server)
		self.server.add_insecure_port('[::]:50051')
		self.server.start()

	def generateMonster(self, request, context):
		ID = request.id
		if(ID == -1 or ID > 5):
			ID = randrange(6)

		monster = monster_list[ID]
		return monster;



lock = threading.Lock()
java_stub = None
ruby_stub = None

hero_list = []

def print_menu():
	print('Numero de heros = ['+str(len(hero_list))+']')
	print('Numero de monsters = ['+str(len(monster_list))+']')
	print('PyApp Menu:')
	print('rb-hero \t\t\t Selecionar um hero')
	print('java-dice \t\t\t Jogar um dado')
	print('java-combat \t\t\t Realizar um combate')
	print('sm \t\t\t\t listar monsters')
	print('sh \t\t\t\t listar heros')
	print('q \t\t\t\t Sair')

def switch_op(op):
	if(op == 'rb-hero'):
		hero_id = hero_pkg.HeroID()
		hero_id.id = int(input('Digite o id do héroi:'))
		
		hero = ruby_stub.getHero(hero_id)
		hero_list.append(hero)
		hero_list.sort(key=lambda hero: hero.id)

	if(op == 'java-dice'):
		t = input('Tipo do dado (D4,D6,D8,D10,D12,D20,D100):')
		dice_type = dice_pkg.DiceType(tipoDado=t.upper())

		rolledDice = java_stub.rollDice(dice_type)
		print('\n\nO dado '+str(rollDice.type)+' rolou: '+str(rollDice.rolledNumber))

	if(op == 'java-combat'):
		hero = input('Entre o id do hero: ')
		for h in hero_list:
			if(h.id == hero)
				hero = h
				break

		monster = monster_list(randrange(6))
		combat = combat_pkg.Combat()

		combat.atk_strength = hero.strength
		combat.atk_resistance = hero.resistance
		combat.atk_health = hero.health

		combat.def_strength = monster.strength
		combat.def_resistance = monster.resistance
		combat.def_health = monster.health

		print('\n\n'+hero.name + 'VS' + monster.name)
		combat = java_stub.calculateCombat(combat)

		if(combat.who_won == 'Defender'):
			print('\nVencedor: ' + monster.name)
		else:
			print('\nVencedor: ' + hero.name)


	if(op == 'sm'):
		for monster in monster_list:
			print('#######')
			print('id: ' + str(monster.id))
			print('name: ' + monster.name)
			print('str: ' + str(monster.strength))
			print('res: ' + str(monster.resistance))
			print('health: '+ str(monster.health))
		print('#######')
	
	if(op == 'sh'):
		for hero in hero_list:
			print('#######')
			print('id: ' + str(hero.id))
			print('name: ' + hero.name)
			print('str: ' + str(hero.strength))
			print('res: ' + str(hero.resistance))
			print('health: '+ str(hero.health))
		print('#######')



if __name__ == '__main__':
	pyApp = PythonApplication()

	lock.acquire()
	pyApp.start()
	lock.release()

	port = ':50052'

	"""Configurando a porta para requisições na aplicação JAVA"""

	java_ip = input('Digite o IP da máquina JAVA: ')
	java_ip += port
	channel = grpc.insecure_channel(java_ip)
	java_stub = app_grpc.javaInterfaceStub(channel)

	"""Configurando a porta para requisições na aplicação RUBY"""

	ruby_ip = input('Digite o IP da máquina RUBY: ')
	ruby_ip += port
	channel = grpc.insecure_channel(ruby_ip)
	ruby_stub = app_grpc.rubyInterfaceStub(channel)


	op = ''
	while True:
		print_menu()
		op = input()
		if(op == 'q'):
			break
		switch_op(op)
	
	pyApp.stop()
	pyApp.join()