package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.model.Customer
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import com.backcountry.fulfillment.cqrs.commands.api.CommandHandler
import com.backcountry.fulfillment.cqrs.commands.cms.CreateCustomer
import com.backcountry.fulfillment.cqrs.events.cms.CustomerCreated
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreateCustomerHandler @Autowired constructor(
        private val customerRepository: CustomerRepository,
        private val eventBus: EventBus): CommandHandler<CreateCustomer> {

    @CommandListener
    override fun handle(command: CreateCustomer) {
        if(!customerRepository.findById(command.email).isPresent) {
            customerRepository.save(Customer(command))
        }
        eventBus.publishEvent(CustomerCreated(command))
    }

}