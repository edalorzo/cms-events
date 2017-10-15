package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.ActivateCustomer
import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.events.CustomerActivated
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActivateCustomerHandler(@Autowired val customerRepository: CustomerRepository,
                              val eventBus: EventBus): CommandHandler<ActivateCustomer> {

    @CommandListener
    override fun handle(command: ActivateCustomer) {

        customerRepository.findById(command.email)
                .orElseThrow { RuntimeException("Customer not found for email ${command.email}") }
                .execute(command)

        eventBus.publishEvent(CustomerActivated(command))

    }
}