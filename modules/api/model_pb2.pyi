from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class ConnectionDTO(_message.Message):
    __slots__ = ["location", "person"]
    LOCATION_FIELD_NUMBER: _ClassVar[int]
    PERSON_FIELD_NUMBER: _ClassVar[int]
    location: LocationDTO
    person: PersonDTO
    def __init__(self, location: _Optional[_Union[LocationDTO, _Mapping]] = ..., person: _Optional[_Union[PersonDTO, _Mapping]] = ...) -> None: ...

class LocationDTO(_message.Message):
    __slots__ = ["createdAt", "latitude", "longitude"]
    CREATEDAT_FIELD_NUMBER: _ClassVar[int]
    LATITUDE_FIELD_NUMBER: _ClassVar[int]
    LONGITUDE_FIELD_NUMBER: _ClassVar[int]
    createdAt: str
    latitude: float
    longitude: float
    def __init__(self, latitude: _Optional[float] = ..., longitude: _Optional[float] = ..., createdAt: _Optional[str] = ...) -> None: ...

class PersonDTO(_message.Message):
    __slots__ = ["companyName", "firstName", "id", "lastName"]
    COMPANYNAME_FIELD_NUMBER: _ClassVar[int]
    FIRSTNAME_FIELD_NUMBER: _ClassVar[int]
    ID_FIELD_NUMBER: _ClassVar[int]
    LASTNAME_FIELD_NUMBER: _ClassVar[int]
    companyName: str
    firstName: str
    id: int
    lastName: str
    def __init__(self, id: _Optional[int] = ..., firstName: _Optional[str] = ..., lastName: _Optional[str] = ..., companyName: _Optional[str] = ...) -> None: ...
