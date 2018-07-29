package org.tonycox.garage.user.api.model

import java.time.LocalTime

data class Trip(val driver: Driver,
                val route: Route,
                val vehicle: Vehicle,
                val sitCount: Long,
                val price: Money,
                val departureTime: LocalTime,
                val arriveTime: LocalTime)