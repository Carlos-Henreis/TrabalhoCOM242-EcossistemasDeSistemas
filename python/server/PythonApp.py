import grpc
from random import randrange

from messages import application_pb2 as app
from interfaces.application_pb2_grpc import pythonInterfaceServicer
from messages.Monster_pb2 import *

class PythonApp(pythonInterfaceServicer):
	
	def selfGenerateMonster(self,monsterQt):
		qt = monsterQt.qt
		monsters = Monsters()
		for n in qt:
			monster = globals()['monsters'][randrange(qt)]
			monsters.append(monster)
		return monsters
	def generateMonster(self, request, context):
		response = selfGenerateMonster(request)
		return response