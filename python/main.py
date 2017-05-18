
import time
import threading

from controller.Switcher import *
from interfaces import application_pb2_grpc as app_grpc

from messages import application_pb2 as app
from messages import Monster_pb2 as monster_pkg
from messages import Hero_pb2 as hero_pkg
from messages import Dice_pb2 as dice_pkg
from messages import Combat_pb2 as combat_pkg

from server.PythonApp import *
from server.Server import *

sys.path.append(__file__)

globals()['monsters'] = []
globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][0].id = 0
globals()['monsters'][0].name = 'goblin'
globals()['monsters'][0].strength = 1
globals()['monsters'][0].resistance = 16
globals()['monsters'][0].health = 5

globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][1].id = 1
globals()['monsters'][1].name = 'orc'
globals()['monsters'][1].strength = 2
globals()['monsters'][1].resistance = 12
globals()['monsters'][1].health = 10

globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][2].id = 2
globals()['monsters'][2].name = 'ogre'
globals()['monsters'][2].strength = 4
globals()['monsters'][2].resistance = 12
globals()['monsters'][2].health = 20

globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][3].id = 3
globals()['monsters'][3].name = 'troll'
globals()['monsters'][3].strength = 4
globals()['monsters'][3].resistance = 16
globals()['monsters'][3].health = 30

globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][4].id = 4
globals()['monsters'][4].name = 'beholder'
globals()['monsters'][4].strength = 6
globals()['monsters'][4].resistance = 15
globals()['monsters'][4].health = 20

globals()['monsters'].append(monster_pkg.Monster())
globals()['monsters'][5].id = 5
globals()['monsters'][5].name = 'dragon'
globals()['monsters'][5].strength = 10
globals()['monsters'][5].resistance = 20
globals()['monsters'][5].health = 40

globals()['javaStub'] = None
globals()['rubyStub'] = None
globals()['javaIP'] = None
globals()['rubyIP'] = None

lock = threading.Lock()
java_stub = None
ruby_stub = None


def print_menu():
    print("Python Application:")
    print("jvip \t\t\t Change JavaApp ip")
    print("rbip \t\t\t Change RubyApp ip")
    print("sc \t\t\t Start Combat")
    print("rh \t\t\t Register Hero")
    print("sh \t\t\t Show Heroes")
    print("rd \t\t\t Roll Dice")
    print("q  \t\t\t Quit App")



ms = monster_pkg.Monsters

if __name__ == '__main__':
	pyServer = Server()

	lock.acquire()
	pyServer.start()
	lock.release()


	while True:
		print_menu()
		op = input()
		if(op == 'q'):
			break
		switch_op(op)

	pyServer.stop()
	pyServer.join()
