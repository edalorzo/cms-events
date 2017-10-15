package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CreateCustomer
import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.model.Customer
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AddCustomerHandler(@Autowired val customerRepository: CustomerRepository): CommandHandler<CreateCustomer> {

    @Transactional
    @CommandListener
    override fun handle(command: CreateCustomer) {
        if(customerRepository.findById(command.email).isPresent) {
            throw RuntimeException("The customer ${command.email} already exists")
        }
        customerRepository.save(Customer(command))
    }

}