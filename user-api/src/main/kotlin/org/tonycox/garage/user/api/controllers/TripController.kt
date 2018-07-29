package org.tonycox.garage.user.api.controllers

import org.springframework.web.bind.annotation.*
import org.tonycox.garage.user.api.model.ReservationInfo
import org.tonycox.garage.user.api.model.Trip

@RestController
@RequestMapping("/trip")
class TripController {

    @GetMapping("/{tripId}")
    fun viewTripInfo(@PathVariable tripId: String): Trip? {
        // ...
        return null
    }

    @GetMapping("/search/from/{origin}/to/{destination}")
    fun searchTripsInDirection(@PathVariable origin: String, @PathVariable destination: String): List<Trip>? {
        // ...
        return null
    }

    @PostMapping("/reserve")
    fun reserveTrip(@RequestBody reservationInfo: ReservationInfo): List<Trip>? {
        // ...
        return null
    }

    @PostMapping("/leave/{tripId}")
    fun leaveTrip(@PathVariable tripId: String): List<Trip>? {
        // ...
        return null
    }
}
