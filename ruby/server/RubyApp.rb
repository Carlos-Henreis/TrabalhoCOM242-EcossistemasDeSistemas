require 'grpc'
require_relative '../interfaces/application_services_pb'


class RubyApp < RubyInterface::Service
	def get_hero(heroId_req, _unused_call)
		self.self_get_hero
	end

	def set_hero(hero_req, _unused_call)
		self.self_set_hero
	end

	def add_hero(hero_req, _unused_call)
		self.self_add_hero
	end

	# -- local calls
	def self_get_hero(heroId)
		if(heroId != -1)
		    return	$hero_list.select{ |h| h == heroId.id}
		end
		$hero_list
	end

	def self_set_hero(hero)
		$hero_list.delete_if{ |h| h.id == hero.id }
		$hero_list << hero
	end

	def self_add_hero(hero)
		$hero_list << hero
		$hero_list.uniq!
	end
end
