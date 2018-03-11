package org.tonycox.garage.app.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.Serializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import org.tonycox.garage.app.event.SearchMessage
import java.util.*

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@Configuration
@EnableKafka
class KafkaProducerConfig {
    @Autowired
    private lateinit var kafkaProducerProperties: KafkaProducerProperties

    @Bean
    fun searchMessageKafkaTemplate(): KafkaTemplate<String, SearchMessage> {
        val kafkaTemplate = KafkaTemplate<String, SearchMessage>(producerFactory())
        kafkaTemplate.defaultTopic = kafkaProducerProperties.topic
        return kafkaTemplate
    }

    @Bean
    fun producerConfigs(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProducerProperties.bootstrap
        return props
    }

    @Bean
    fun producerFactory(): ProducerFactory<String, SearchMessage> {
        return DefaultKafkaProducerFactory<String, SearchMessage>(producerConfigs(),
                stringKeySerializer(), messageJsonSerializer())
    }

    @Bean
    fun stringKeySerializer(): Serializer<String> {
        return StringSerializer()
    }

    @Bean
    fun messageJsonSerializer(): Serializer<SearchMessage> {
        return JsonSerializer<SearchMessage>()
    }
}
