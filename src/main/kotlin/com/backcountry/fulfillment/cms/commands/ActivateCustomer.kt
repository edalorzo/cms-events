package com.backcountry.fulfillment.cms.commands

import com.backcountry.fulfillment.cms.commands.api.Command
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ActivateCustomer @JsonCreator constructor(
        @JsonProperty("email") val email: String
): Command