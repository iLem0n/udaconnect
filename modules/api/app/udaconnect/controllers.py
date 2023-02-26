from datetime import datetime

from app.udaconnect.schemas import (
    ConnectionSchema,
    LocationSchema,
    PersonSchema,
)
from flask import request
from flask_accepts import responds
from flask_restx import Namespace, Resource
from typing import Optional, List
from app.client import GrpcClient

DATE_FORMAT = "%Y-%m-%d"

api = Namespace("UdaConnect", description="Connections via geolocation.")  # noqa

@api.route("/persons")
class PersonsResource(Resource):
    client = GrpcClient()

    def map_person_schema(self, p):
        ret = PersonSchema()
        ret.id = p.id
        ret.first_name = p.firstName
        ret.last_name = p.lastName
        ret.company_name = p.companyName
        return ret

    @responds(schema=PersonSchema, many=True)
    def get(self) -> List[PersonSchema]:

        reply = self.client.get_persons()
        return map(self.map_person_schema, reply.persons)



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
        return map(self.map_connection_schema, reply.connections)
