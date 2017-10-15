package com.backcountry.fulfillment.cms.commands.endpoints.listener

import com.backcountry.fulfillment.cms.commands.ActivateCustomer
import com.backcountry.fulfillment.cms.commands.ChangePassword
import com.backcountry.fulfillment.cms.commands.CreateCustomer
import com.backcountry.fulfillment.cms.commands.DeactivateCustomer
import com.backcountry.fulfillment.cms.commands.api.CommandBus
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
@RabbitListener(queues = arrayOf("ffd.customer.commands"), containerFactory = "commandBus")
class CommandListener(@Autowired private val commandBus: CommandBus) {

    @RabbitHandler
    fun createCustomer(command: CreateCustomer) {
        commandBus.publishCommand(command)
    }

    @RabbitHandler
    fun changePassword(command: ChangePassword) {
        commandBus.publishCommand(command)
    }

    @RabbitHandler
    fun activateCustomer(command: ActivateCustomer) {
        commandBus.publishCommand(command)
    }

    @RabbitHandler
    fun deactivateCustomer(command: DeactivateCustomer) {
        commandBus.publishCommand(command)
    }

}