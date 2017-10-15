package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.ChangePassword
import com.backcountry.fulfillment.cms.commands.CommandListener
import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ChangePasswordHandler(@Autowired val customerRepository: CustomerRepository) : CommandHandler<ChangePassword> {

    @Transactional
    @CommandListener
    override fun handle(command: ChangePassword) {

        customerRepository.findById(command.email)
                .orElseThrow { RuntimeException("Customer not found for email ${command.email}") }
                .execute(command)

    }
}