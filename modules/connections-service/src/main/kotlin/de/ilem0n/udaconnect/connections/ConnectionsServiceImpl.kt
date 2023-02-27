package de.ilem0n.udaconnect.connections

import de.ilem0n.udaconnect.rpc.Connections
import de.ilem0n.udaconnect.rpc.ConnectionsReply
import de.ilem0n.udaconnect.rpc.ConnectionsRequest
import de.ilem0n.udaconnect.rpc.model.ConnectionDTO
import de.ilem0n.udaconnect.rpc.model.LocationDTO
import de.ilem0n.udaconnect.rpc.model.PersonDTO
import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni
import javax.inject.Inject

@GrpcService
class ConnectionsServiceImpl: Connections {
    @Inject
    lateinit var storage: InMemoryStorage
    override fun getConnections(request: ConnectionsRequest): Uni<ConnectionsReply> {
        val personId = request.personId
        val replyBuilder = ConnectionsReply.newBuilder().setPersonId(personId)

        val connections = storage.connections
            .filter {
                it.persons._1.id == personId || it.persons._2.id == personId
            }
            .map {
                val otherPerson = if (it.persons._1.id == personId) it.persons._2 else it.persons._1
                ConnectionDTO.newBuilder()
                    .setPerson(
                        PersonDTO.newBuilder()
                            .setId(otherPerson.id)
                            .setFirstName(otherPerson.firstName)
                            .setLastName(otherPerson.lastName)
                            .setCompanyName(otherPerson.companyName)
                    )
                    .setLocation(
                        LocationDTO.newBuilder()
                            .setLatitude(it.location.coordinate.latitude)
                            .setLongitude(it.location.coordinate.longitude)
                            .setCreatedAt(it.location.createdAt.toString())
                    )
                    .build()
            }

        replyBuilder.addAllConnections(connections)
        return Uni.createFrom().item(
            replyBuilder.build()
        )
    }
}

