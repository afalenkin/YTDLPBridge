package com.afalenkin.ytdlpbridge.integration

import com.afalenkin.ytdlpbridge.integration.model.CommandMessage
import jakarta.validation.constraints.NotBlank
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer


/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(
        @Value(value = "\${spring.kafka.bootstrap-servers}") @NotBlank bootstrapAddress: String,
        @Value(value = "\${spring.kafka.consumer.group-id}") @NotBlank groupId: String,
    ): ConsumerFactory<String, CommandMessage> {
        val props = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapAddress,
            ConsumerConfig.GROUP_ID_CONFIG to groupId,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java
        )
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, CommandMessage>
    ) = ConcurrentKafkaListenerContainerFactory<String, CommandMessage>()
        .also { it.setConsumerFactory(consumerFactory) }
}