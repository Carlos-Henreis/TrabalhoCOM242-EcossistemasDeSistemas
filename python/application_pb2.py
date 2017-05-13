# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: application.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from messages import Hero_pb2 as messages_dot_Hero__pb2
from messages import Combat_pb2 as messages_dot_Combat__pb2
from messages import Dice_pb2 as messages_dot_Dice__pb2
from messages import Monster_pb2 as messages_dot_Monster__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='application.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x11\x61pplication.proto\x1a\x13messages/Hero.proto\x1a\x15messages/Combat.proto\x1a\x13messages/Dice.proto\x1a\x16messages/Monster.proto2,\n\rrubyInterface\x12\x1b\n\x07getHero\x12\x07.HeroID\x1a\x05.Hero\"\x00\x32<\n\x0fpythonInterface\x12)\n\x0fgenerateMonster\x12\n.MonsterId\x1a\x08.Monster\"\x00\x32W\n\rjavaInterface\x12&\n\x0f\x63\x61lculateCombat\x12\x08.Monster\x1a\x07.Combat\"\x00\x12\x1e\n\x08rollDice\x12\t.DiceType\x1a\x05.Dice\"\x00\x62\x06proto3')
  ,
  dependencies=[messages_dot_Hero__pb2.DESCRIPTOR,messages_dot_Combat__pb2.DESCRIPTOR,messages_dot_Dice__pb2.DESCRIPTOR,messages_dot_Monster__pb2.DESCRIPTOR,])
_sym_db.RegisterFileDescriptor(DESCRIPTOR)





try:
  # THESE ELEMENTS WILL BE DEPRECATED.
  # Please use the generated *_pb2_grpc.py files instead.
  import grpc
  from grpc.beta import implementations as beta_implementations
  from grpc.beta import interfaces as beta_interfaces
  from grpc.framework.common import cardinality
  from grpc.framework.interfaces.face import utilities as face_utilities


  class rubyInterfaceStub(object):

    def __init__(self, channel):
      """Constructor.

      Args:
        channel: A grpc.Channel.
      """
      self.getHero = channel.unary_unary(
          '/rubyInterface/getHero',
          request_serializer=messages_dot_Hero__pb2.HeroID.SerializeToString,
          response_deserializer=messages_dot_Hero__pb2.Hero.FromString,
          )


  class rubyInterfaceServicer(object):

    def getHero(self, request, context):
      context.set_code(grpc.StatusCode.UNIMPLEMENTED)
      context.set_details('Method not implemented!')
      raise NotImplementedError('Method not implemented!')


  def add_rubyInterfaceServicer_to_server(servicer, server):
    rpc_method_handlers = {
        'getHero': grpc.unary_unary_rpc_method_handler(
            servicer.getHero,
            request_deserializer=messages_dot_Hero__pb2.HeroID.FromString,
            response_serializer=messages_dot_Hero__pb2.Hero.SerializeToString,
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
          request_serializer=messages_dot_Monster__pb2.MonsterId.SerializeToString,
          response_deserializer=messages_dot_Monster__pb2.Monster.FromString,
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
            request_deserializer=messages_dot_Monster__pb2.MonsterId.FromString,
            response_serializer=messages_dot_Monster__pb2.Monster.SerializeToString,
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
          request_serializer=messages_dot_Monster__pb2.Monster.SerializeToString,
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
            request_deserializer=messages_dot_Monster__pb2.Monster.FromString,
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


  class BetarubyInterfaceServicer(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def getHero(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)


  class BetarubyInterfaceStub(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def getHero(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    getHero.future = None


  def beta_create_rubyInterface_server(servicer, pool=None, pool_size=None, default_timeout=None, maximum_timeout=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_deserializers = {
      ('rubyInterface', 'getHero'): messages_dot_Hero__pb2.HeroID.FromString,
    }
    response_serializers = {
      ('rubyInterface', 'getHero'): messages_dot_Hero__pb2.Hero.SerializeToString,
    }
    method_implementations = {
      ('rubyInterface', 'getHero'): face_utilities.unary_unary_inline(servicer.getHero),
    }
    server_options = beta_implementations.server_options(request_deserializers=request_deserializers, response_serializers=response_serializers, thread_pool=pool, thread_pool_size=pool_size, default_timeout=default_timeout, maximum_timeout=maximum_timeout)
    return beta_implementations.server(method_implementations, options=server_options)


  def beta_create_rubyInterface_stub(channel, host=None, metadata_transformer=None, pool=None, pool_size=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_serializers = {
      ('rubyInterface', 'getHero'): messages_dot_Hero__pb2.HeroID.SerializeToString,
    }
    response_deserializers = {
      ('rubyInterface', 'getHero'): messages_dot_Hero__pb2.Hero.FromString,
    }
    cardinalities = {
      'getHero': cardinality.Cardinality.UNARY_UNARY,
    }
    stub_options = beta_implementations.stub_options(host=host, metadata_transformer=metadata_transformer, request_serializers=request_serializers, response_deserializers=response_deserializers, thread_pool=pool, thread_pool_size=pool_size)
    return beta_implementations.dynamic_stub(channel, 'rubyInterface', cardinalities, options=stub_options)


  class BetapythonInterfaceServicer(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def generateMonster(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)


  class BetapythonInterfaceStub(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def generateMonster(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    generateMonster.future = None


  def beta_create_pythonInterface_server(servicer, pool=None, pool_size=None, default_timeout=None, maximum_timeout=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_deserializers = {
      ('pythonInterface', 'generateMonster'): messages_dot_Monster__pb2.MonsterId.FromString,
    }
    response_serializers = {
      ('pythonInterface', 'generateMonster'): messages_dot_Monster__pb2.Monster.SerializeToString,
    }
    method_implementations = {
      ('pythonInterface', 'generateMonster'): face_utilities.unary_unary_inline(servicer.generateMonster),
    }
    server_options = beta_implementations.server_options(request_deserializers=request_deserializers, response_serializers=response_serializers, thread_pool=pool, thread_pool_size=pool_size, default_timeout=default_timeout, maximum_timeout=maximum_timeout)
    return beta_implementations.server(method_implementations, options=server_options)


  def beta_create_pythonInterface_stub(channel, host=None, metadata_transformer=None, pool=None, pool_size=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_serializers = {
      ('pythonInterface', 'generateMonster'): messages_dot_Monster__pb2.MonsterId.SerializeToString,
    }
    response_deserializers = {
      ('pythonInterface', 'generateMonster'): messages_dot_Monster__pb2.Monster.FromString,
    }
    cardinalities = {
      'generateMonster': cardinality.Cardinality.UNARY_UNARY,
    }
    stub_options = beta_implementations.stub_options(host=host, metadata_transformer=metadata_transformer, request_serializers=request_serializers, response_deserializers=response_deserializers, thread_pool=pool, thread_pool_size=pool_size)
    return beta_implementations.dynamic_stub(channel, 'pythonInterface', cardinalities, options=stub_options)


  class BetajavaInterfaceServicer(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def calculateCombat(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)
    def rollDice(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)


  class BetajavaInterfaceStub(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def calculateCombat(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    calculateCombat.future = None
    def rollDice(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    rollDice.future = None


  def beta_create_javaInterface_server(servicer, pool=None, pool_size=None, default_timeout=None, maximum_timeout=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_deserializers = {
      ('javaInterface', 'calculateCombat'): messages_dot_Monster__pb2.Monster.FromString,
      ('javaInterface', 'rollDice'): messages_dot_Dice__pb2.DiceType.FromString,
    }
    response_serializers = {
      ('javaInterface', 'calculateCombat'): messages_dot_Combat__pb2.Combat.SerializeToString,
      ('javaInterface', 'rollDice'): messages_dot_Dice__pb2.Dice.SerializeToString,
    }
    method_implementations = {
      ('javaInterface', 'calculateCombat'): face_utilities.unary_unary_inline(servicer.calculateCombat),
      ('javaInterface', 'rollDice'): face_utilities.unary_unary_inline(servicer.rollDice),
    }
    server_options = beta_implementations.server_options(request_deserializers=request_deserializers, response_serializers=response_serializers, thread_pool=pool, thread_pool_size=pool_size, default_timeout=default_timeout, maximum_timeout=maximum_timeout)
    return beta_implementations.server(method_implementations, options=server_options)


  def beta_create_javaInterface_stub(channel, host=None, metadata_transformer=None, pool=None, pool_size=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_serializers = {
      ('javaInterface', 'calculateCombat'): messages_dot_Monster__pb2.Monster.SerializeToString,
      ('javaInterface', 'rollDice'): messages_dot_Dice__pb2.DiceType.SerializeToString,
    }
    response_deserializers = {
      ('javaInterface', 'calculateCombat'): messages_dot_Combat__pb2.Combat.FromString,
      ('javaInterface', 'rollDice'): messages_dot_Dice__pb2.Dice.FromString,
    }
    cardinalities = {
      'calculateCombat': cardinality.Cardinality.UNARY_UNARY,
      'rollDice': cardinality.Cardinality.UNARY_UNARY,
    }
    stub_options = beta_implementations.stub_options(host=host, metadata_transformer=metadata_transformer, request_serializers=request_serializers, response_deserializers=response_deserializers, thread_pool=pool, thread_pool_size=pool_size)
    return beta_implementations.dynamic_stub(channel, 'javaInterface', cardinalities, options=stub_options)
except ImportError:
  pass
# @@protoc_insertion_point(module_scope)
