package com.afalenkin.ytdlpbridge.integration

import com.afalenkin.ytdlpbridge.integration.model.CommandMessage
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Component
class KafkaListeners {

    @KafkaListener(
        topics = ["\$spring.kafka.topics.ytdlp.name:"],
        groupId = "\$spring.kafka.consumer.group-id",
    )
    fun handleMessage(@Payload message: CommandMessage) {
        println(message)
    }
}