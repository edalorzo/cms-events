package com.backcountry.fulfillment.cms.events

import com.backcountry.fulfillment.cms.commands.CreateCustomer
import com.backcountry.fulfillment.cms.events.api.Event
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerCreated @JsonCreator constructor(
        @JsonProperty("email") val email: String,
        @JsonProperty("firstName") val firstName: String,
        @JsonProperty("lastName") val lastName: String) : Event {

    constructor(command: CreateCustomer) : this(
            command.email,
            command.firstName,
            command.lastName)

    override fun getRoutingKey() = "ffd.Customer.CustomerCreated"
}