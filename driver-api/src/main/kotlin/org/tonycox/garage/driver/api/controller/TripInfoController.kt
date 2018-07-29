package org.tonycox.garage.driver.api.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.tonycox.garage.driver.api.model.TripInfo

/**
 * @author Anton Solovev
 * @since 3/15/2018.
 */
@RestController
@RequestMapping("/trip/info")
class TripInfoController {

    @Autowired
    private lateinit var originToTripInfo: MutableMap<String, MutableList<TripInfo>>

    @GetMapping("/getFirst/{origin}")
    fun getFirst(@PathVariable origin: String): TripInfo? {
        return originToTripInfo[origin]?.get(0) ?: throw RuntimeException()
    }

    @GetMapping("/getSome/{origin}/{from}/{to}")
    fun getSome(@PathVariable origin: String, @PathVariable from: Int = 0, @PathVariable to: Int = 0): List<TripInfo>? {
        return originToTripInfo[origin]?.subList(from, to)
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTrip(@RequestBody tripInfo: TripInfo): String {
        val origin = tripInfo.path[0]
        originToTripInfo.computeIfAbsent(origin, { _ -> mutableListOf(tripInfo) })
        originToTripInfo.computeIfPresent(origin, { _, list -> list.add(tripInfo); list })
        // push to kafka message new trip created!
        return origin
    }
}
