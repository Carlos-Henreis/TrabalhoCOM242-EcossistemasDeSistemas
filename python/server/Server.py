from concurrent import futures

import grpc
import threading
from server.PythonApp import *

from messages import application_pb2 as app
from interfaces import application_pb2_grpc as app_grpc

class Server (threading.Thread):
    def __init__(self):
    	threading.Thread.__init__(self)
    	app_grpc.pythonInterfaceServicer.__init__(self)
    	self._stop_event = threading.Event()
    	self.server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    	self.server.add_insecure_port('[::]:50051')
    	app_grpc.add_pythonInterfaceServicer_to_server(PythonApp(),self.server)
    def stop(self):
    	self.server.stop(0)
    	self._stop_event.set()
    def run(self):
    	self.server.start()
