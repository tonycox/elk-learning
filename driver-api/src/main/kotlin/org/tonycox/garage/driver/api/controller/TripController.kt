package org.tonycox.garage.driver.api.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.tonycox.garage.driver.api.model.Passenger
import org.tonycox.garage.driver.api.model.Trip

/**
 * @author Anton Solovev
 * @since 3/15/2018.
 */
@RestController
@RequestMapping("/trip")
class TripController {

    @GetMapping("/{tripId}")
    fun viewTripInfo(@PathVariable tripId: String): Trip? {
        // ...
        return null
    }

    @GetMapping("/{tripId}/passengers")
    fun viewAllPassengersInTrip(@PathVariable tripId: String): List<Passenger>? {
        // ...
        return null
    }

    @PostMapping("/reservation/close/{tripId}")
    @ResponseStatus(HttpStatus.OK)
    fun closeForReservationTrip(@PathVariable tripId: String): String {
        // ...
        return "id"
    }

    @PostMapping("/reservation/open")
    @ResponseStatus(HttpStatus.OK)
    fun openForReservationTrip(@RequestBody trip: Trip): String {
        // ...
        // checks and validation
        return "id"
    }

    @PostMapping("/cancel/{tripId}")
    @ResponseStatus(HttpStatus.OK)
    fun cancelTrip(@PathVariable tripId: String): String {
        // ...
        // checks and validation
        return "id"
    }

    @PostMapping("/change")
    @ResponseStatus(HttpStatus.OK)
    fun changeTripInfo(@RequestBody trip: Trip): String {
        // ...
        // checks and validation
        return "id"
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTrip(@RequestBody trip: Trip): String {
        // ...
        return "id"
    }
}
