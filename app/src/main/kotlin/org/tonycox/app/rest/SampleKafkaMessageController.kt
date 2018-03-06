package org.tonycox.app.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.tonycox.app.event.SearchMessage
import org.tonycox.app.messaging.SearchService

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@RestController/*("/search") todo some gus here*/
class SampleKafkaMessageController {
    @Autowired
    private lateinit var searchService: SearchService

    @PostMapping("/start")
    fun sendMessage(@RequestBody message: SearchMessage): Boolean {
        return searchService.send(message)
    }
}
