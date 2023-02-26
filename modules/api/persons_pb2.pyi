import model_pb2 as _model_pb2
from google.protobuf import empty_pb2 as _empty_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class PersonsReply(_message.Message):
    __slots__ = ["persons"]
    PERSONS_FIELD_NUMBER: _ClassVar[int]
    persons: _containers.RepeatedCompositeFieldContainer[_model_pb2.PersonDTO]
    def __init__(self, persons: _Optional[_Iterable[_Union[_model_pb2.PersonDTO, _Mapping]]] = ...) -> None: ...
