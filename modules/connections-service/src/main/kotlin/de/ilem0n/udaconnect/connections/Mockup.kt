package de.ilem0n.udaconnect.connections

import de.ilem0n.udaconnect.connections.model.Coordinate
import de.ilem0n.udaconnect.connections.model.Location
import de.ilem0n.udaconnect.connections.model.Person
import io.quarkus.runtime.StartupEvent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject

@ApplicationScoped
class Mockup {
    @Inject
    private lateinit var messageProcessor: MessageProcessor

    fun onStartup(@Observes event: StartupEvent) {
        listOf(
            Person(id = 5, firstName = "Taco", lastName = "Fargo", companyName = "Alpha Omega Upholstery"),
            Person(id = 6, firstName = "Frank", lastName = "Shader", companyName = "USDA"),
            Person(id = 1, firstName = "Pam", lastName = "Trexler", companyName = "Hampton, Hampton and McQuill"),
            Person(id = 8, firstName = "Paul", lastName = "Badman", companyName = "Paul Badman & Associates"),
            Person(id = 9, firstName = "Otto", lastName = "Spring", companyName = "The Chicken Sisters Restaurant")
        ).forEach(messageProcessor::processPerson)

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        listOf(
            Location(id = 29, personId = 1, coordinate = Coordinate(37.553441, -122.290524), createdAt = LocalDateTime.parse("2020-08-18 10:37:06", formatter)),
            Location(id = 30, personId = 5, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-08-15 10:37:06", formatter)),
            Location(id = 31, personId = 5, coordinate = Coordinate(37.553441, -122.290524), createdAt = LocalDateTime.parse("2020-08-15 10:37:06", formatter)),
            Location(id = 32, personId = 1, coordinate = Coordinate(37.553441, -122.290521), createdAt = LocalDateTime.parse("2020-08-15 10:37:06", formatter)),
            Location(id = 33, personId = 1, coordinate = Coordinate(37.553451, -122.290521), createdAt = LocalDateTime.parse("2020-08-19 10:37:06", formatter)),
            Location(id = 34, personId = 6, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 36, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 37, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 38, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 39, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 40, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 41, personId = 1, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 42, personId = 6, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 43, personId = 6, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-06 10:37:06", formatter)),
            Location(id = 44, personId = 6, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 45, personId = 6, coordinate = Coordinate(35.058506, -106.5722575), createdAt = LocalDateTime.parse("2020-07-05 10:37:06", formatter)),
            Location(id = 46, personId = 6, coordinate = Coordinate(35.058564, -106.5721845), createdAt = LocalDateTime.parse("2020-04-07 10:37:06", formatter)),
            Location(id = 47, personId = 6, coordinate = Coordinate(35.058564, -106.5721846), createdAt = LocalDateTime.parse("2020-05-01 10:37:06", formatter)),
            Location(id = 48, personId = 6, coordinate = Coordinate(35.058564, -106.5721845), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 49, personId = 8, coordinate = Coordinate(35.058564, -106.5721845), createdAt = LocalDateTime.parse("2020-07-07 10:38:06", formatter)),
            Location(id = 50, personId = 8, coordinate = Coordinate(35.058564, -106.5721846), createdAt = LocalDateTime.parse("2020-07-07 10:38:06", formatter)),
            Location(id = 51, personId = 8, coordinate = Coordinate(35.058564, -106.5721846), createdAt = LocalDateTime.parse("2020-07-01 10:38:06", formatter)),
            Location(id = 52, personId = 9, coordinate = Coordinate(35.058564, -106.5721846), createdAt = LocalDateTime.parse("2020-07-01 10:38:06", formatter)),
            Location(id = 53, personId = 9, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 54, personId = 9, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2019-07-07 10:37:06", formatter)),
            Location(id = 55, personId = 5, coordinate = Coordinate(35.0585136, -105.5719566), createdAt = LocalDateTime.parse("2019-07-07 10:37:06", formatter)),
            Location(id = 56, personId = 5, coordinate = Coordinate(34.0585136, -105.5719566), createdAt = LocalDateTime.parse("2019-07-07 10:37:06", formatter)),
            Location(id = 57, personId = 5, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 58, personId = 8, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 59, personId = 8, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 60, personId = 8, coordinate = Coordinate(35.0585136, -106.5719566), createdAt = LocalDateTime.parse("2020-07-06 10:37:06", formatter)),
            Location(id = 61, personId = 8, coordinate = Coordinate(35.0585136, -106.5719561), createdAt = LocalDateTime.parse("2020-07-05 10:37:06", formatter)),
            Location(id = 62, personId = 8, coordinate = Coordinate(35.0585136, -106.5719521), createdAt = LocalDateTime.parse("2020-01-05 10:37:06", formatter)),
            Location(id = 63, personId = 5, coordinate = Coordinate(35.0585136, -106.5719521), createdAt = LocalDateTime.parse("2020-01-05 10:37:06", formatter)),
            Location(id = 64, personId = 6, coordinate = Coordinate(35.0585136, -106.5719521), createdAt = LocalDateTime.parse("2020-01-05 10:37:06", formatter)),
            Location(id = 65, personId = 9, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 66, personId = 5, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 67, personId = 8, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-07-07 10:37:06", formatter)),
            Location(id = 68, personId = 6, coordinate = Coordinate(37.55363, -122.290883), createdAt = LocalDateTime.parse("2020-08-15 10:37:06", formatter))

        ).forEach(messageProcessor::processLocation)
    }
}