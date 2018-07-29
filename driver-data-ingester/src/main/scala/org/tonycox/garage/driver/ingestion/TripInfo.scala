package org.tonycox.garage.driver.ingestion

import java.time.LocalTime

/**
	* @author Anton Solovev
	* @since 17.03.2018
	*/
class TripInfo(
	val driverId: Long,
	val path: List[String],
	val departureTime: LocalTime,
	val arriveTime: LocalTime) {


}
