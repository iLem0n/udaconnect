package de.ilem0n.udaconnect.connections

import de.ilem0n.udaconnect.connections.model.Connection
import de.ilem0n.udaconnect.connections.model.Location
import de.ilem0n.udaconnect.connections.model.Person
import javaslang.Tuple2
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class MessageProcessor {

    @Inject
    lateinit var storage: InMemoryStorage

    @Incoming("persons")
    fun processPerson(person: Person) {
        storage.persons.add(person)
        updateConnections()
    }

    @Incoming("locations")
    fun processLocation(location: Location) {
        storage.locations.add(location)
        updateConnections()
    }

    private fun updateConnections() {
        evaluateConnections()
            .filter(this::isNewConnection)
            .forEach(this::persistConnection)
    }

    private fun evaluateConnections(): List<Connection> {
        return storage.persons
            .map { person ->
                getConnectionsForPerson(person)
            }
            .flatten()
    }

    private fun getConnectionsForPerson(person: Person): List<Connection> {
        val personLocations = storage.locations.filter { it.isLocationOf(person) }
        val foreignLocations = storage.locations.filterNot { it.isLocationOf(person) }
        val connections = mutableListOf<Connection>()

        foreignLocations.forEach { foreignLocation ->
            personLocations.forEach { personLocation ->
                val distance = personLocation.distanceToLocation(foreignLocation)
                if (distance < 5) {
                    val foreignPerson = storage.persons.first { it.id == foreignLocation.personId }
                    val connection = Connection(personLocation, Tuple2(person, foreignPerson))
                    if (!connections.contains(connection)) {
                        connections.add(connection)
                    }
                }
            }
        }

        println("${person.firstName} ${person.lastName} has ${connections.size} connections.")
        for (connection in connections) {
            println(connection)
        }
        return connections
    }

    private fun isNewConnection(connection: Connection): Boolean {
        return storage.connections
            .none {
                connection.isBetweenTheSamePersons.test(it)
            }
    }


    private fun persistConnection(connection: Connection) {
        storage.connections.add(connection)
    }
}


