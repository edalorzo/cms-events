package com.backcountry.fulfillment.cms.controllers

import com.backcountry.fulfillment.cms.commands.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Transactional
@RestController
@RequestMapping("/customer")
class CustomerController(@Autowired private val commandBus: CommandBus) {

    @PostMapping("/create-customer")
    fun createCustomer(@RequestBody command: CreateCustomer) {
        commandBus.publishCommand(command)
    }

    @PostMapping("/change-password")
    fun changePassword(@RequestBody command: ChangePassword) {
        commandBus.publishCommand(command)
    }

    @PostMapping("/activate")
    fun activateCustomer(@RequestBody command: ActivateCustomer) {
        commandBus.publishCommand(command)
    }

    @PostMapping("/deactivate")
    fun deactivateCustomer(@RequestBody command: DeactivateCustomer) {
        commandBus.publishCommand(command)
    }

}