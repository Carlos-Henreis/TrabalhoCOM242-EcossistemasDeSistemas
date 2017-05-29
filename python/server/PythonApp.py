import grpc
import google.protobuf
from random import randrange

from messages import application_pb2 as app
from interfaces.application_pb2_grpc import pythonInterfaceServicer
from messages.Monster_pb2 import *
from messages import Monster_pb2 as monster_pkg

monsters_list = []
monsters_list.append(monster_pkg.Monster())
monsters_list[0].id = 0
monsters_list[0].name = 'goblin'
monsters_list[0].strength = 1
monsters_list[0].resistance = 16
monsters_list[0].health = 5

monsters_list.append(monster_pkg.Monster())
monsters_list[1].id = 1
monsters_list[1].name = 'orc'
monsters_list[1].strength = 2
monsters_list[1].resistance = 12
monsters_list[1].health = 10

monsters_list.append(monster_pkg.Monster())
monsters_list[2].id = 2
monsters_list[2].name = 'ogre'
monsters_list[2].strength = 4
monsters_list[2].resistance = 12
monsters_list[2].health = 20

monsters_list.append(monster_pkg.Monster())
monsters_list[3].id = 3
monsters_list[3].name = 'troll'
monsters_list[3].strength = 4
monsters_list[3].resistance = 16
monsters_list[3].health = 30

monsters_list.append(monster_pkg.Monster())
monsters_list[4].id = 4
monsters_list[4].name = 'beholder'
monsters_list[4].strength = 6
monsters_list[4].resistance = 15
monsters_list[4].health = 20

monsters_list.append(monster_pkg.Monster())
monsters_list[5].id = 5
monsters_list[5].name = 'Sir Pericles'
monsters_list[5].strength = 6666
monsters_list[5].resistance = 6666
monsters_list[5].health = 9000000

monsters_list.append(monster_pkg.Monster())
monsters_list[6].id = 6
monsters_list[6].name = 'dragon'
monsters_list[6].strength = 10
monsters_list[6].resistance = 20
monsters_list[6].health = 40



class PythonApp(pythonInterfaceServicer):
	
	def selfGenerateMonster(self,monsterQt):
		qt = monsterQt.qt
		monsters = Monsters()
		for n in range(qt):
			m = monsters_list[randrange(6)]
			mons = monsters.monster.add()
			mons.id = m.id
			mons.name = m.name
			mons.strength = m.strength
			mons.resistance = m.resistance
			mons.health = m.health
		return monsters
	def generateMonster(self, request, context):
		response = self.selfGenerateMonster(request)
		return response