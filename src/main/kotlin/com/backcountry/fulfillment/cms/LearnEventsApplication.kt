package com.backcountry.fulfillment.cms

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager
import org.springframework.context.annotation.Primary
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.orm.jpa.JpaTransactionManager
import javax.persistence.EntityManagerFactory
import org.springframework.data.transaction.ChainedTransactionManager

@SpringBootApplication
class LearnEventsApplication

@Configuration
class LearnEventsApplicationConfiguration {

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = Jackson2JsonMessageConverter(ObjectMapper())
        return rabbitTemplate
    }

    @Bean
    fun rabbitTransactionManager(connectionFactory: ConnectionFactory): PlatformTransactionManager {
        return RabbitTransactionManager(connectionFactory)
    }

    @Bean
    fun jpaTransactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(emf)
    }

    @Bean
    @Primary
    fun transactionManager(jpaTransactionManager: PlatformTransactionManager,
                                  rabbitTransactionManager: PlatformTransactionManager): PlatformTransactionManager {
        return ChainedTransactionManager(rabbitTransactionManager, jpaTransactionManager)
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(LearnEventsApplication::class.java, *args)
}