#require 'grpc'
require_relative 'server/Server'
require_relative 'server/RubyApp'
require_relative 'controller/Switcher'

#require_relative 'interfaces/application_services_pb'

require_relative 'messages/Combat_pb'
require_relative 'messages/Dice_pb'
require_relative 'messages/Hero_pb'
require_relative 'messages/Monster_pb'

$hero_list = []
$hero_list << Hero.new(id: 0,
					   name: 'Frodo',
					   strength: 1,
					   resistance: 20,
					   health: 10,
					   maxHealth: 10)
$hero_list << Hero.new(id: 1,
					   name: 'Aragorn',
					   strength: 4,
					   resistance: 17,
					   health: 18,
					   maxHealth: 18)
$hero_list << Hero.new(id: 2,
					   name: 'Legolas',
					   strength: 4,
					   resistance: 19,
					   health: 15,
					   maxHealth: 15)
$hero_list << Hero.new(id: 3,
					   name: 'Gandalf',
					   strength: 20,
					   resistance: 14,
					   health: 15,
					   maxHealth: 15)
$hero_list << Hero.new(id: 4,
					   name: 'Gimli',
					   strength: 10,
					   resistance: 19,
					   health: 20,
					   maxHealth: 20)
$hero_list << Hero.new(id: 666,
					   name: 'Chuck Norris',
					   strength: 99999,
					   resistance: 99999,
					   health: 99999,
					   maxHealth: 99999)


$monster_list = []

def print_menu
    puts "Python Application:"
    puts "jvip \t\t\t Change JavaApp ip"
    puts "pyip \t\t\t Change PythonApp ip"
    puts "sc \t\t\t Start Combat"
    puts "rh \t\t\t Register Hero"
    puts "sh \t\t\t Show Heroes"
    puts "rd \t\t\t Roll Dice"
    puts "q  \t\t\t Quit App"
end


def main
	server = RubyServer.new
	server.run
	
	switcher = Switcher.new
	op = ''
	while true
		print_menu
		op = gets.chomp
		if switcher.send(op) == :die
			break
		end
	end

	# Finalizando a execução da thread
	
	if server.th.alive?
		Thread.kill(server.th)
		server.th.join
	end
end

main
