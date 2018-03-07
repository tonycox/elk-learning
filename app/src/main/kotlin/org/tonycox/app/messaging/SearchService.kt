package org.tonycox.app.messaging

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.tonycox.app.event.SearchMessage


/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@Service
class SearchService {

    companion object {
        private val logger = LoggerFactory.getLogger(SearchService::class.java)
    }

    @Value("\${kafka.producer.topic}")
    private lateinit var topicName: String

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, SearchMessage>

    fun send(msg: SearchMessage): Boolean {
        val sendResult = kafkaTemplate.send(topicName, msg).get()
        val recordMetadata = sendResult.recordMetadata
        logger.info("topic = {}, partition = {}, offset = {}, searchMessage = {}",
                recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), msg)
        return true
    }
}
