package org.tonycox.garage.driver.api.model

import java.time.LocalTime

/**
 * @author Anton Solovev
 * @since 3/15/2018.
 */
data class TripInfo(val driverId: Long,
                    val path: List<String>,
                    val sitCount: Long,
                    val departureTime: LocalTime,
                    val arriveTime: LocalTime)
