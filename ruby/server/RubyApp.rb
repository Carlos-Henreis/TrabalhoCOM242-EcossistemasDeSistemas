require 'grpc'
require_relative '../interfaces/application_services_pb'
require_relative '../messages/Hero_pb'



class RubyApp < RubyInterface::Service
	def get_hero(heroId_req, _unused_call)
		h = Heroes.new
		h.hero.concat self.self_get_hero(heroId_req)
		h
	end

	def set_hero(hero_req, _unused_call)
		h = Heroes.new
		h.hero.concat self.self_set_hero(hero_req)
		h
	end

	def add_hero(hero_req, _unused_call)
		h.Heroes.new
		h.hero.concat self.self_add_hero(hero_req)
		h
	end

	# -- local calls
	def self_get_hero(heroId)
		$hero_list.delete_if{ |h| h.health <= 0}

		if(heroId.id != -1)
		    return	$hero_list.select{ |h| h.id == heroId.id}
		end
		return $hero_list
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
