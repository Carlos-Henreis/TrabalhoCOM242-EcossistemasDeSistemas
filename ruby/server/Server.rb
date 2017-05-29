require 'grpc'
require_relative '../interfaces/application_services_pb'
require_relative 'RubyApp'

class RubyServer 
	def run
		@th = Thread.new do
			server = GRPC::RpcServer.new
			server.add_http2_port('0.0.0.0:50051',:this_port_is_insecure)
			server.handle(RubyApp)
			server.run_till_terminated
		end
	end 
	def th
	    @th
	end
end
