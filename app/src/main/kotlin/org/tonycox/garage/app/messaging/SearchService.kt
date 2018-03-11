package org.tonycox.garage.app.messaging

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.tonycox.garage.app.event.SearchMessage
import org.tonycox.garage.app.loggerFor

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@Service
class SearchService {

    companion object {
        private val logger = loggerFor(SearchService::class.java)
    }

    @Value("\${kafka.producer.topic}")
    private lateinit var topicName: String

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, SearchMessage>

    fun send(msg: SearchMessage): Long {
        val sendResult = kafkaTemplate.send(topicName, msg).get()
        val recordMetadata = sendResult.recordMetadata
        val offset = recordMetadata.offset()
        logger.info("topic = {}, partition = {}, offset = {}, searchMessage = {}",
                recordMetadata.topic(), recordMetadata.partition(), offset, msg)
        return offset
    }
}
