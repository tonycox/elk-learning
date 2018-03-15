package org.tonycox.garage.driver.api.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.tonycox.garage.driver.api.model.TripInfo
import java.time.LocalTime
import java.util.*
import java.util.concurrent.atomic.AtomicLong


/**
 * @author Anton Solovev
 * @since 3/15/2018.
 */
@Configuration
class TripInitializtion {

    private val idGenerator: AtomicLong = AtomicLong()
    private val randGenerator = Random()

    @Bean
    fun tripMap(): Map<String, List<TripInfo>> {
        val trips = listOf(
                generateTrip("Someplace"),
                generateTrip("Someplace"),
                generateTrip("Someplace"),
                generateTrip("Someplace"))
        val trips2 = listOf(
                generateTrip("AnotherPlace"),
                generateTrip("AnotherPlace"),
                generateTrip("AnotherPlace"),
                generateTrip("AnotherPlace"))
        val trips3 = listOf(
                generateTrip("SignificantlyOtherPlace"),
                generateTrip("SignificantlyOtherPlace"),
                generateTrip("SignificantlyOtherPlace"),
                generateTrip("SignificantlyOtherPlace"))

        return mapOf(Pair("Someplace", trips), Pair("AnotherPlace", trips2), Pair("SignificantlyOtherPlace", trips3))
    }

    fun generateTrip(origin: String): TripInfo {
        val (time, time1) = randomTime()
        return TripInfo(idGenerator.incrementAndGet(),
                listOf(origin, UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                randGenerator.nextInt(6).toLong(), time, time1)
    }

    fun randomTime(): Pair<LocalTime, LocalTime> {
        val time: LocalTime = LocalTime.now().plusSeconds(randGenerator.nextInt().toLong())
        val nextTime = time.plusMinutes(30L).plusHours(randGenerator.nextInt(20).toLong())
        return Pair(time, nextTime)
    }
}