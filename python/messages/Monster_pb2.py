# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: messages/Monster.proto

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
  name='messages/Monster.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x16messages/Monster.proto\"Y\n\x07Monster\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x0c\n\x04name\x18\x02 \x01(\t\x12\x10\n\x08strength\x18\x03 \x01(\x05\x12\x12\n\nresistance\x18\x04 \x01(\x05\x12\x0e\n\x06health\x18\x05 \x01(\x05\"\x17\n\tMonsterId\x12\n\n\x02id\x18\x01 \x01(\x05\x62\x06proto3')
)
_sym_db.RegisterFileDescriptor(DESCRIPTOR)




_MONSTER = _descriptor.Descriptor(
  name='Monster',
  full_name='Monster',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='Monster.id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='name', full_name='Monster.name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='strength', full_name='Monster.strength', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='resistance', full_name='Monster.resistance', index=3,
      number=4, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='health', full_name='Monster.health', index=4,
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
  serialized_start=26,
  serialized_end=115,
)


_MONSTERID = _descriptor.Descriptor(
  name='MonsterId',
  full_name='MonsterId',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='MonsterId.id', index=0,
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
  serialized_start=117,
  serialized_end=140,
)

DESCRIPTOR.message_types_by_name['Monster'] = _MONSTER
DESCRIPTOR.message_types_by_name['MonsterId'] = _MONSTERID

Monster = _reflection.GeneratedProtocolMessageType('Monster', (_message.Message,), dict(
  DESCRIPTOR = _MONSTER,
  __module__ = 'messages.Monster_pb2'
  # @@protoc_insertion_point(class_scope:Monster)
  ))
_sym_db.RegisterMessage(Monster)

MonsterId = _reflection.GeneratedProtocolMessageType('MonsterId', (_message.Message,), dict(
  DESCRIPTOR = _MONSTERID,
  __module__ = 'messages.Monster_pb2'
  # @@protoc_insertion_point(class_scope:MonsterId)
  ))
_sym_db.RegisterMessage(MonsterId)


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