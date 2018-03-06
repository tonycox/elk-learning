package org.tonycox.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */

@SpringBootApplication
class ApplicationMain

fun main(args: Array<String>) {
    runApplication<ApplicationMain>(*args)
}
