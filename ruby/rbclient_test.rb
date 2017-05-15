require 'grpc'

require_relative 'application_pb'
require_relative 'application_services_pb'

require_relative 'messages/Combat_pb'
require_relative 'messages/Dice_pb'
require_relative 'messages/Hero_pb'
require_relative 'messages/Monster_pb'

def main
	stub = RubyInterface::Stub.new("localhost:50051", :this_channel_is_insecure)
	p "hai"
	heroId = HeroID.new(id: 10)
	message = stub.get_hero(heroId)
	puts message.name + String(message.id)	
end
main