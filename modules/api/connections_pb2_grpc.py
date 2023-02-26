# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import connections_pb2 as connections__pb2


class ConnectionsStub(object):
    """The greeting service definition.
    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.GetConnections = channel.unary_unary(
                '/connections.Connections/GetConnections',
                request_serializer=connections__pb2.ConnectionsRequest.SerializeToString,
                response_deserializer=connections__pb2.ConnectionsReply.FromString,
                )


class ConnectionsServicer(object):
    """The greeting service definition.
    """

    def GetConnections(self, request, context):
        """Sends a greeting
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_ConnectionsServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'GetConnections': grpc.unary_unary_rpc_method_handler(
                    servicer.GetConnections,
                    request_deserializer=connections__pb2.ConnectionsRequest.FromString,
                    response_serializer=connections__pb2.ConnectionsReply.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'connections.Connections', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class Connections(object):
    """The greeting service definition.
    """

    @staticmethod
    def GetConnections(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/connections.Connections/GetConnections',
            connections__pb2.ConnectionsRequest.SerializeToString,
            connections__pb2.ConnectionsReply.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)