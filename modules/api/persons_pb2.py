# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: persons.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


import model_pb2 as model__pb2
from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2


DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\rpersons.proto\x12\x07persons\x1a\x0bmodel.proto\x1a\x1bgoogle/protobuf/empty.proto\"+\n\x0cPersonsReply\x12\x1b\n\x07persons\x18\x01 \x03(\x0b\x32\n.PersonDTO2H\n\x07Persons\x12=\n\nGetPersons\x12\x16.google.protobuf.Empty\x1a\x15.persons.PersonsReply\"\x00\x42,\n\x18\x64\x65.ilem0n.udaconnect.rpcB\x0ePersonsServiceP\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'persons_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\030de.ilem0n.udaconnect.rpcB\016PersonsServiceP\001'
  _PERSONSREPLY._serialized_start=68
  _PERSONSREPLY._serialized_end=111
  _PERSONS._serialized_start=113
  _PERSONS._serialized_end=185
# @@protoc_insertion_point(module_scope)