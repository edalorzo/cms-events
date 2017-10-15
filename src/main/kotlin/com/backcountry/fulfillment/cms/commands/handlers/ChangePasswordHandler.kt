package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.ChangePassword
import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.events.PasswordChanged
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ChangePasswordHandler(@Autowired val customerRepository: CustomerRepository,
                            val eventBus: EventBus) : CommandHandler<ChangePassword> {

    @CommandListener
    override fun handle(command: ChangePassword) {

        customerRepository.findById(command.email)
                .orElseThrow { RuntimeException("Customer not found for email ${command.email}") }
                .execute(command)

        eventBus.publishEvent(PasswordChanged(command))

    }
}