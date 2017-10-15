package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.commands.DeactivateCustomer
import com.backcountry.fulfillment.cms.events.CustomerDeactivated
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeactivateCustomerHandler(@Autowired val customerRepository: CustomerRepository,
                                val eventBus: EventBus) : CommandHandler<DeactivateCustomer> {

    @CommandListener
    override fun handle(command: DeactivateCustomer) {

        customerRepository.findById(command.email)
                .orElseThrow { RuntimeException("Customer not found for email ${command.email}") }
                .execute(command)

        eventBus.publishEvent(CustomerDeactivated(command))

    }
}