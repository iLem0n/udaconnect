from datetime import datetime

from app.udaconnect.models import Connection, Location, Person
from app.udaconnect.schemas import (
    ConnectionSchema,
    LocationSchema,
    PersonSchema,
)
from app.udaconnect.services import ConnectionService, LocationService, PersonService
from flask import request
from flask_accepts import accepts, responds
from flask_restx import Namespace, Resource
from typing import Optional, List
from app.client import GrpcClient

DATE_FORMAT = "%Y-%m-%d"

api = Namespace("UdaConnect", description="Connections via geolocation.")  # noqa


# TODO: This needs better exception handling


@api.route("/locations")
@api.route("/locations/<location_id>")
@api.param("location_id", "Unique ID for a given Location", _in="query")
class LocationResource(Resource):
    @accepts(schema=LocationSchema)
    @responds(schema=LocationSchema)
    def post(self) -> Location:
        request.get_json()
        location: Location = LocationService.create(request.get_json())
        return location

    @responds(schema=LocationSchema)
    def get(self, location_id) -> Location:
        location: Location = LocationService.retrieve(location_id)
        return location


@api.route("/persons")
class PersonsResource(Resource):
    client = GrpcClient()

    @accepts(schema=PersonSchema)
    @responds(schema=PersonSchema)
    def post(self) -> Person:
        payload = request.get_json()
        new_person: Person = PersonService.create(payload)
        return new_person

    def map_person_schema(self, p):
        ret = PersonSchema()
        ret.id = p.id
        ret.first_name = p.firstName
        ret.last_name = p.lastName
        ret.company_name = p.companyName
        return ret

    @responds(schema=PersonSchema, many=True)
    def get(self) -> List[Person]:

        reply = self.client.get_persons()
        return map(self.map_person_schema, reply.persons)


@api.route("/persons/<person_id>")
@api.param("person_id", "Unique ID for a given Person", _in="query")
class PersonResource(Resource):
    @responds(schema=PersonSchema)
    def get(self, person_id) -> Person:
        person: Person = PersonService.retrieve(person_id)
        return person


@api.route("/persons/<person_id>/connection")
@api.param("start_date", "Lower bound of date range", _in="query")
@api.param("end_date", "Upper bound of date range", _in="query")
@api.param("distance", "Proximity to a given user in meters", _in="query")
class ConnectionDataResource(Resource):
    client = GrpcClient()

    def map_connection_schema(self, c):
        connection = ConnectionSchema()
        location = LocationSchema()
        location.latitude = c.location.latitude
        location.longitude = c.location.longitude
        location.creation_time = datetime.now()

        person = PersonSchema()
        person.id = c.person.id
        person.first_name = c.person.firstName
        person.last_name = c.person.lastName
        person.company_name = c.person.companyName

        connection.location = location
        connection.person = person
        return connection

    @responds(schema=ConnectionSchema, many=True)
    def get(self, person_id) -> ConnectionSchema:
        start_date: datetime = datetime.strptime(
            request.args["start_date"], DATE_FORMAT
        )
        end_date: datetime = datetime.strptime(request.args["end_date"], DATE_FORMAT)
        distance: Optional[int] = request.args.get("distance", 5)

        reply = self.client.get_connections(person_id)
        print("CONNECTIONS: ")

        return map(self.map_connection_schema, reply.connections)
