package de.ilem0n.udaconnect.connections.model

import kotlin.math.*

object Geo {
    fun distanceInMeters(coordinate1: Coordinate, coordinate2: Coordinate): Double {
        val R = 6371; // km
        val dLat = Math.toRadians(coordinate2.latitude-coordinate1.latitude)
        val dLon = Math.toRadians(coordinate2.longitude-coordinate1.longitude)
        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(Math.toRadians(coordinate1.latitude)) * cos(Math.toRadians(coordinate2.latitude)) *
                sin(dLon / 2) * sin(dLon / 2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return ceil(R * c * 1000)
    }
}