package com.backcountry.fulfillment.cms.events

import com.backcountry.fulfillment.cms.commands.CreateCustomer

data class CustomerCreated (
        val email: String,
        val firstName: String,
        val lastName: String) : Event {

    constructor(command: CreateCustomer) : this(
            command.email,
            command.firstName,
            command.lastName)

    override fun getRoutingKey() = "ffd.Customer.CustomerCreated"
}