import model_pb2 as _model_pb2
from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class ConnectionsReply(_message.Message):
    __slots__ = ["connections", "personId"]
    CONNECTIONS_FIELD_NUMBER: _ClassVar[int]
    PERSONID_FIELD_NUMBER: _ClassVar[int]
    connections: _containers.RepeatedCompositeFieldContainer[_model_pb2.ConnectionDTO]
    personId: int
    def __init__(self, personId: _Optional[int] = ..., connections: _Optional[_Iterable[_Union[_model_pb2.ConnectionDTO, _Mapping]]] = ...) -> None: ...

class ConnectionsRequest(_message.Message):
    __slots__ = ["personId"]
    PERSONID_FIELD_NUMBER: _ClassVar[int]
    personId: int
    def __init__(self, personId: _Optional[int] = ...) -> None: ...
