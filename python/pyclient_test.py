from __future__ import print_function

import grpc

import application_pb2 as app
import application_pb2_grpc as app_grpc
from messages import Monster_pb2 as monster_pkg

def run():
  channel = grpc.insecure_channel('localhost:50051')
  stub = app_grpc.pythonInterfaceStub(channel)
  response = stub.generateMonster(monster_pkg.MonsterId(id=-1))
  print("Greeter client received: " + response.name)


if __name__ == '__main__':
	run()