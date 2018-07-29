package org.tonycox.garage.driver.api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@Component
@ConfigurationProperties("kafka")
class KafkaProducerProperties {
    @Value("\${bootstrap-server}")
    lateinit var bootstrap: String
    @Value("\${producer.topic}")
    lateinit var topic: String
}
