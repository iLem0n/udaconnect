import grpc
import persons_pb2_grpc as persons_pb2_grpc
import connections_pb2_grpc as connections_pb2_grpc
import connections_pb2 as connections_pb2
from google.protobuf import empty_pb2 as google_dot_protobuf_dot_empty__pb2

class GrpcClient(object):
    """
    Client for gRPC functionality
    """

    def __init__(self):
        self.host = 'udaconnect-connection-service'
        self.server_port = 9000

        # instantiate a channel
        self.channel = grpc.insecure_channel(
            '{}:{}'.format(self.host, self.server_port))

        # bind the client and the grpc
        self.persons_stub = persons_pb2_grpc.PersonsStub(self.channel)
        self.connections_stub = connections_pb2_grpc.ConnectionsStub(self.channel)

    def get_persons(self):
        return self.persons_stub.GetPersons(google_dot_protobuf_dot_empty__pb2.Empty())

    def get_connections(self, person_id):
        request = connections_pb2.ConnectionsRequest()
        request.personId = int(person_id)
        return self.connections_stub.GetConnections(request)
