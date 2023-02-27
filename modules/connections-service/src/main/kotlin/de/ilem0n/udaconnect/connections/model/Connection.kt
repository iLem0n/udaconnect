package de.ilem0n.udaconnect.connections.model

import javaslang.Tuple2
import java.util.function.Predicate

data class Connection(
    val location: Location,
    val persons: Tuple2<Person, Person>
) {
    var isBetweenTheSamePersons: Predicate<Connection> = Predicate { otherConnection ->
        val reversedTuple = Tuple2(otherConnection.persons._2, otherConnection.persons._1)
        this.persons == otherConnection.persons || this.persons == reversedTuple
    }
}
