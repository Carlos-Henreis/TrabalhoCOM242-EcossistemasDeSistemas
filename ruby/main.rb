require 'grpc'

require_relative 'application_pb'
require_relative 'application_services_pb'

require_relative 'messages/Combat_pb'
require_relative 'messages/Dice_pb'
require_relative 'messages/Hero_pb'
require_relative 'messages/Monster_pb'

class RubyServer < RubyInterface::Service
	def get_hero(heroId_req, _unused_call)
		mhero = Hero.new(id: heroId_req.id ,name: "bambam")
		
		mhero.strength = 10
		mhero.resistance = 10
		mhero.health = 100
		return mhero
	end
end

def main
	th_server = Thread.new{
		server = GRPC::RpcServer.new
		server.add_http2_port('0.0.0.0:50051',:this_port_is_insecure)
		server.handle(RubyServer)
		server.run_till_terminated
		puts "ding"
	}
	op = ''
	while op != "q"
		puts "digite uma opção:"
		op = gets.chomp
		
	end

	# Finalizando a execução da thread
	if th_server.alive?
		Thread.kill(th_server)
		th_server.join
	end
end 

main