package org.tonycox.garage.driver.api.model

import java.time.LocalTime

/**
 * @author Anton Solovev
 * @since 3/15/2018.
 */
data class Trip(val driver: Driver,
                val route: Route,
                val vehicle: Vehicle,
                val sitCount: Long,
                val price: Money,
                val departureTime: LocalTime,
                val arriveTime: LocalTime)
