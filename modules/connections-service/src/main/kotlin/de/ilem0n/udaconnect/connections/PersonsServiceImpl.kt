package de.ilem0n.udaconnect.connections

import com.google.protobuf.Empty
import de.ilem0n.udaconnect.rpc.Persons
import de.ilem0n.udaconnect.rpc.PersonsReply
import de.ilem0n.udaconnect.rpc.model.PersonDTO
import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni
import javax.inject.Inject

@GrpcService
class PersonsServiceImpl: Persons {
    @Inject
    lateinit var storage: InMemoryStorage

    override fun getPersons(request: Empty?): Uni<PersonsReply> {
        val replyBuilder = PersonsReply.newBuilder()
        val persons = storage.persons
            .map {
                PersonDTO.newBuilder()
                    .setId(it.id)
                    .setFirstName(it.firstName)
                    .setLastName(it.lastName)
                    .setCompanyName(it.companyName)
                    .build()
            }

        replyBuilder.addAllPersons(persons)
        println("return persons: $persons")
        return Uni.createFrom().item {
            replyBuilder.build()
        }
    }
}

