from concurrent import futures

import grpc
import threading
import time

import application_pb2 as app
import application_pb2_grpc as app_grpc

from messages import Monster_pb2 as monster_pkg
from messages import Hero_pb2 as hero_pkg

from random import randrange



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
		if(ID == -1):
			ID = randrange(6)

		monster = monster_pkg.Monster()
		monster.id = ID

		if(monster.id == 0):
			monster.name = 'goblin'
			monster.strength = 1
			monster.resistance = 16
			monster.health = 5
		elif(monster.id == 1):
			monster.name = 'orc'
			monster.strength = 2
			monster.resistance = 12
			monster.health = 10
		elif(monster.id == 2):
			monster.name = 'ogre'
			monster.strength = 4
			monster.resistance = 12
			monster.health = 20
		elif(monster.id == 3):
			monster.name = 'troll'
			monster.strength = 4
			monster.resistance = 16
			monster.health = 30
		elif(monster.id == 4):
			monster.name = 'beholder'
			monster.strength = 6
			monster.resistance = 15
			monster.health = 20
		elif(monster.id == 5):
			monster.name = 'dragon'
			monster.strength = 10
			monster.resistance = 20
			monster.health = 40

		return monster;

lock = threading.Lock()
java_stub = None
ruby_stub = None

def print_menu():
	print('PyApp Menu:')
	print('rb-hero \t Selecionar um hero')
	print('java-dice \t Jogar um dado')
	print('java-combat \t Realizar um combate')

def switch_op(op):
	if(op == 'rb-hero'):
		hero_id = hero_pkg.HeroID()
		hero_id.id = int(input('Digite o id do héroi:'))
		
		hero = ruby_stub.getHero(hero_id)
		print(hero.name)


if __name__ == '__main__':
	pyApp = PythonApplication()

	lock.acquire()
	pyApp.start()
	lock.release()

	port = ':50052'

	"""Configurando a porta para requisições na aplicação JAVA""

	java_ip = input('Digite o IP da máquina JAVA: ')
	java_ip += port
	channel = grpc.insecure_channel(java_ip)
	java_stub = app_grpc.javaInterfaceStub(channel)"""

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