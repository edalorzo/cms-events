package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.commands.DeactivateCustomer
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DeactivateCustomerHandler(@Autowired val customerRepository: CustomerRepository) : CommandHandler<DeactivateCustomer> {

    @Transactional
    @CommandListener
    override fun handle(command: DeactivateCustomer) {

        customerRepository.findById(command.email)
                .orElseThrow { RuntimeException("Customer not found for email ${command.email}") }
                .execute(command)

    }
}