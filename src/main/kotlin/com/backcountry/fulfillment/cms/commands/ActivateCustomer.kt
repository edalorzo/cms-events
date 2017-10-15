package com.backcountry.fulfillment.cms.commands

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ActivateCustomer @JsonCreator constructor(@JsonProperty("email") val email: String): Command