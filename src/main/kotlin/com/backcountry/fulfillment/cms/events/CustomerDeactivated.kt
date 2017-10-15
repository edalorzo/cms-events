package com.backcountry.fulfillment.cms.events

import com.backcountry.fulfillment.cms.commands.DeactivateCustomer
import com.backcountry.fulfillment.cms.events.api.Event
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerDeactivated @JsonCreator constructor(
        @JsonProperty("email") val email: String): Event {

    constructor(command: DeactivateCustomer): this(command.email)

    override fun getRoutingKey() = "ffd.Customer.CustomerDeactivated"
}