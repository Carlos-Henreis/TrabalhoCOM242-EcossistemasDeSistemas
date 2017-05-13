# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: messages/Hero.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='messages/Hero.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x13messages/Hero.proto\"V\n\x04Hero\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x0c\n\x04name\x18\x02 \x01(\t\x12\x10\n\x08strength\x18\x03 \x01(\x05\x12\x12\n\nresistance\x18\x04 \x01(\x05\x12\x0e\n\x06health\x18\x05 \x01(\x05\"\x14\n\x06HeroID\x12\n\n\x02id\x18\x01 \x01(\x05\x62\x06proto3')
)
_sym_db.RegisterFileDescriptor(DESCRIPTOR)




_HERO = _descriptor.Descriptor(
  name='Hero',
  full_name='Hero',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='Hero.id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='name', full_name='Hero.name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='strength', full_name='Hero.strength', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='resistance', full_name='Hero.resistance', index=3,
      number=4, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='health', full_name='Hero.health', index=4,
      number=5, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=23,
  serialized_end=109,
)


_HEROID = _descriptor.Descriptor(
  name='HeroID',
  full_name='HeroID',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='HeroID.id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=111,
  serialized_end=131,
)

DESCRIPTOR.message_types_by_name['Hero'] = _HERO
DESCRIPTOR.message_types_by_name['HeroID'] = _HEROID

Hero = _reflection.GeneratedProtocolMessageType('Hero', (_message.Message,), dict(
  DESCRIPTOR = _HERO,
  __module__ = 'messages.Hero_pb2'
  # @@protoc_insertion_point(class_scope:Hero)
  ))
_sym_db.RegisterMessage(Hero)

HeroID = _reflection.GeneratedProtocolMessageType('HeroID', (_message.Message,), dict(
  DESCRIPTOR = _HEROID,
  __module__ = 'messages.Hero_pb2'
  # @@protoc_insertion_point(class_scope:HeroID)
  ))
_sym_db.RegisterMessage(HeroID)


try:
  # THESE ELEMENTS WILL BE DEPRECATED.
  # Please use the generated *_pb2_grpc.py files instead.
  import grpc
  from grpc.beta import implementations as beta_implementations
  from grpc.beta import interfaces as beta_interfaces
  from grpc.framework.common import cardinality
  from grpc.framework.interfaces.face import utilities as face_utilities
except ImportError:
  pass
# @@protoc_insertion_point(module_scope)
