from concurrent import futures
import time

import grpc

import application_pb2 as app
import application_pb2_grpc as app_grpc
from messages import Monster_pb2 as monster_pkg
from random import randrange

class pythonInterface (app_grpc.pythonInterfaceServicer):

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


def serve():
	server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
	app_grpc.add_pythonInterfaceServicer_to_server(pythonInterface(),server)
	server.add_insecure_port('[::]:50051')
	server.start()
	try:
		while True:
			time.sleep(3660)
	except KeyboardInterrupt:
		server.stop(0)

if __name__ == '__main__':
	serve()
