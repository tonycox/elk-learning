package org.tonycox.garage.driver.ingestion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Anton Solovev
 * @since 3/14/2018.
 */
@SpringBootApplication
class LocationIngesterApp

fun main(args: Array<String>) {
    runApplication<LocationIngesterApp>(*args)
}
