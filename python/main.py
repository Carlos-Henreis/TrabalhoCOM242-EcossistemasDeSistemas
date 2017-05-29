
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





lock = threading.Lock()

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
