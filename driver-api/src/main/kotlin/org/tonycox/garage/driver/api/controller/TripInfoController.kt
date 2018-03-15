package org.tonycox.garage.driver.api.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
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
    private lateinit var originToTripInfo: Map<String, List<TripInfo>>

    @GetMapping("/getFirst/{origin}")
    fun sendMessage(@PathVariable origin: String): TripInfo? {
        return originToTripInfo[origin]?.get(0) ?: throw RuntimeException()
    }

    @GetMapping("/getSome/{origin}/{from}/{to}")
    fun getSearchResult(@PathVariable origin: String, @PathVariable from: Int = 0, @PathVariable to: Int = 0): List<TripInfo>? {
        return originToTripInfo[origin]?.subList(from, to)
    }
}
