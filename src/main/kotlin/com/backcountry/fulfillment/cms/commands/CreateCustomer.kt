package com.backcountry.fulfillment.cms.commands

import com.backcountry.fulfillment.cms.commands.api.Command
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CreateCustomer @JsonCreator constructor(
        @JsonProperty("email") val email: String,
        @JsonProperty("firstName") val firstName: String,
        @JsonProperty("lastName") val lastName: String
): Command