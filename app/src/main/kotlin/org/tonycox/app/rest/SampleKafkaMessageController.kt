package org.tonycox.app.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.tonycox.app.event.SearchMessage
import org.tonycox.app.messaging.SearchService

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@RestController
@RequestMapping("/search")
class SampleKafkaMessageController {
    @Autowired
    private lateinit var searchService: SearchService

    @PostMapping("/start")
    fun sendMessage(@RequestBody message: SearchMessage): Long {
        return searchService.send(message)
    }

    @GetMapping("/result")
    fun getSearchResult(@RequestBody message: SearchMessage): String {
        return "stub"
    }
}
