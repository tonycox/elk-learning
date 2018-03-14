package org.tonycox.garage.driver.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Anton Solovev
 * @since 3/14/2018.
 */
@SpringBootApplication
class DriverApiApplication

fun main(args: Array<String>) {
    runApplication<DriverApiApplication>(*args)
}