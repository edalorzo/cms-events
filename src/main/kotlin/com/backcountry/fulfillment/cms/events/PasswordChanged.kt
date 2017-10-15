package com.backcountry.fulfillment.cms.events

import com.backcountry.fulfillment.cms.commands.ChangePassword
import com.backcountry.fulfillment.cms.events.api.Event
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class PasswordChanged @JsonCreator constructor(
        @JsonProperty("email") val email: String,
        @JsonProperty("password") val password: String): Event {

    constructor(command: ChangePassword): this(command.email, command.password)

    override fun getRoutingKey() = "ffd.Customer.PasswordChanged";

}
