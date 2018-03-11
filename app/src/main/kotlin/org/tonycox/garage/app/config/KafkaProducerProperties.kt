package org.tonycox.garage.app.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@Component
class KafkaProducerProperties {
    @Value("\${kafka.bootstrap-server}")
    lateinit var bootstrap: String
    @Value("\${kafka.producer.topic}")
    lateinit var topic: String
}
