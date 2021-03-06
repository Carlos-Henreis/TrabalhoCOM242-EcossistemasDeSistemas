# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import messages.Combat_pb2 as messages_dot_Combat__pb2
import messages.Dice_pb2 as messages_dot_Dice__pb2
import messages.Hero_pb2 as messages_dot_Hero__pb2
import messages.Monster_pb2 as messages_dot_Monster__pb2


class rubyInterfaceStub(object):

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.getHero = channel.unary_unary(
        '/rubyInterface/getHero',
        request_serializer=messages_dot_Hero__pb2.HeroID.SerializeToString,
        response_deserializer=messages_dot_Hero__pb2.Heroes.FromString,
        )
    self.setHero = channel.unary_unary(
        '/rubyInterface/setHero',
        request_serializer=messages_dot_Hero__pb2.Hero.SerializeToString,
        response_deserializer=messages_dot_Hero__pb2.Heroes.FromString,
        )
    self.addHero = channel.unary_unary(
        '/rubyInterface/addHero',
        request_serializer=messages_dot_Hero__pb2.Hero.SerializeToString,
        response_deserializer=messages_dot_Hero__pb2.Heroes.FromString,
        )


class rubyInterfaceServicer(object):

  def getHero(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def setHero(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def addHero(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_rubyInterfaceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'getHero': grpc.unary_unary_rpc_method_handler(
          servicer.getHero,
          request_deserializer=messages_dot_Hero__pb2.HeroID.FromString,
          response_serializer=messages_dot_Hero__pb2.Heroes.SerializeToString,
      ),
      'setHero': grpc.unary_unary_rpc_method_handler(
          servicer.setHero,
          request_deserializer=messages_dot_Hero__pb2.Hero.FromString,
          response_serializer=messages_dot_Hero__pb2.Heroes.SerializeToString,
      ),
      'addHero': grpc.unary_unary_rpc_method_handler(
          servicer.addHero,
          request_deserializer=messages_dot_Hero__pb2.Hero.FromString,
          response_serializer=messages_dot_Hero__pb2.Heroes.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'rubyInterface', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))


class pythonInterfaceStub(object):

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.generateMonster = channel.unary_unary(
        '/pythonInterface/generateMonster',
        request_serializer=messages_dot_Monster__pb2.MonsterQt.SerializeToString,
        response_deserializer=messages_dot_Monster__pb2.Monsters.FromString,
        )


class pythonInterfaceServicer(object):

  def generateMonster(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_pythonInterfaceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'generateMonster': grpc.unary_unary_rpc_method_handler(
          servicer.generateMonster,
          request_deserializer=messages_dot_Monster__pb2.MonsterQt.FromString,
          response_serializer=messages_dot_Monster__pb2.Monsters.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'pythonInterface', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))


class javaInterfaceStub(object):

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.calculateCombat = channel.unary_unary(
        '/javaInterface/calculateCombat',
        request_serializer=messages_dot_Combat__pb2.Combat.SerializeToString,
        response_deserializer=messages_dot_Combat__pb2.Combat.FromString,
        )
    self.rollDice = channel.unary_unary(
        '/javaInterface/rollDice',
        request_serializer=messages_dot_Dice__pb2.DiceType.SerializeToString,
        response_deserializer=messages_dot_Dice__pb2.Dice.FromString,
        )


class javaInterfaceServicer(object):

  def calculateCombat(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def rollDice(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_javaInterfaceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'calculateCombat': grpc.unary_unary_rpc_method_handler(
          servicer.calculateCombat,
          request_deserializer=messages_dot_Combat__pb2.Combat.FromString,
          response_serializer=messages_dot_Combat__pb2.Combat.SerializeToString,
      ),
      'rollDice': grpc.unary_unary_rpc_method_handler(
          servicer.rollDice,
          request_deserializer=messages_dot_Dice__pb2.DiceType.FromString,
          response_serializer=messages_dot_Dice__pb2.Dice.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'javaInterface', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
