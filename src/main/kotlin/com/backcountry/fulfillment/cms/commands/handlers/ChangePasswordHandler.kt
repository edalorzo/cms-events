package com.backcountry.fulfillment.cms.commands.handlers



import com.backcountry.fulfillment.cms.commands.CommandListener

import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import com.backcountry.fulfillment.cqrs.commands.api.CommandHandler
import com.backcountry.fulfillment.cqrs.commands.cms.ChangePassword
import com.backcountry.fulfillment.cqrs.events.cms.PasswordChanged
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ChangePasswordHandler @Autowired constructor(
        private val customerRepository: CustomerRepository,
        private val eventBus: EventBus): CommandHandler<ChangePassword> {

    @CommandListener
    override fun handle(command: ChangePassword) {

        customerRepository.findById(command.email)
                .orElseThrow { CustomerNotFoundException(command.email) }
                .execute(command)

        eventBus.publishEvent(PasswordChanged(command))

    }
}