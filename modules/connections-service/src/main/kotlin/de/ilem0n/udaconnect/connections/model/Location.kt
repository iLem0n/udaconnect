package de.ilem0n.udaconnect.connections.model

import java.time.LocalDateTime

data class Location(
    val id: Int,
    val personId: Int,
    val coordinate: Coordinate,
    val createdAt: LocalDateTime
) {
    fun isLocationOf(person: Person): Boolean {
        return person.id == personId
    }

    fun distanceToLocation(other: Location): Double {
        return Geo.distanceInMeters(this.coordinate, other.coordinate)
    }
}

