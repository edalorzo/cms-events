package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.ActivateCustomer
import com.backcountry.fulfillment.cms.commands.api.CommandHandler
import com.backcountry.fulfillment.cms.commands.api.CommandListener
import com.backcountry.fulfillment.cms.events.CustomerActivated
import com.backcountry.fulfillment.cms.events.api.EventBus
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActivateCustomerHandler(@Autowired val customerRepository: CustomerRepository,
                              val eventBus: EventBus): CommandHandler<ActivateCustomer> {

    @CommandListener
    override fun handle(command: ActivateCustomer) {

        customerRepository.findById(command.email)
                .orElseThrow { CustomerNotFoundException(command.email) }
                .execute(command)

        eventBus.publishEvent(CustomerActivated(command))

    }
}