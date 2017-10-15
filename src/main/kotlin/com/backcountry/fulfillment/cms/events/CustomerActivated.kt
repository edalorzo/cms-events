package com.backcountry.fulfillment.cms.events

import com.backcountry.fulfillment.cms.commands.ActivateCustomer
import com.backcountry.fulfillment.cms.events.api.Event
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerActivated @JsonCreator constructor(@JsonProperty("email") val email: String): Event {

    constructor(command: ActivateCustomer): this(command.email)

    override fun getRoutingKey() = "ffd.Customer.CustomerActivated"
}