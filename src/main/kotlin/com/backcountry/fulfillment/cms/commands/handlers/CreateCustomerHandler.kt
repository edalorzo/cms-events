package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.commands.CreateCustomer
import com.backcountry.fulfillment.cms.events.CustomerCreated
import com.backcountry.fulfillment.cms.events.EventBus
import com.backcountry.fulfillment.cms.model.Customer
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreateCustomerHandler(@Autowired val customerRepository: CustomerRepository,
                            val eventBus: EventBus): CommandHandler<CreateCustomer> {

    @CommandListener
    override fun handle(command: CreateCustomer) {
        if(customerRepository.findById(command.email).isPresent) {
            throw RuntimeException("The customer ${command.email} already exists")
        }
        customerRepository.save(Customer(command))
        eventBus.publishEvent(CustomerCreated(command))
    }

}