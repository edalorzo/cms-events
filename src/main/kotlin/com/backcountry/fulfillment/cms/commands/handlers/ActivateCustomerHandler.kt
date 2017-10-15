package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import com.backcountry.fulfillment.cqrs.commands.api.CommandHandler
import com.backcountry.fulfillment.cqrs.commands.cms.ActivateCustomer
import com.backcountry.fulfillment.cqrs.events.cms.CustomerActivated
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActivateCustomerHandler @Autowired constructor(
        private val customerRepository: CustomerRepository,
        private val eventBus: EventBus): CommandHandler<ActivateCustomer> {

    @CommandListener
    override fun handle(command: ActivateCustomer) {

        customerRepository.findById(command.email)
                .orElseThrow { CustomerNotFoundException(command.email) }
                .execute(command)

        eventBus.publishEvent(CustomerActivated(command))

    }
}