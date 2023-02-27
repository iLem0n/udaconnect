package de.ilem0n.udaconnect.connections

import de.ilem0n.udaconnect.connections.model.Connection
import de.ilem0n.udaconnect.connections.model.Location
import de.ilem0n.udaconnect.connections.model.Person
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class InMemoryStorage {
    val persons = mutableListOf<Person>()
    val locations = mutableListOf<Location>()
    val connections = mutableListOf<Connection>()
}