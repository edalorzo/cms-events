package com.backcountry.fulfillment.cms.commands

import com.backcountry.fulfillment.cms.commands.api.Command
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ChangePassword @JsonCreator constructor(
        @JsonProperty("email") val email: String,
        @JsonProperty("password") val password: String
): Command {
    init {
        if(password.length < 5) {
            throw IllegalArgumentException("The password must have at least 5 characters")
        }
    }
}
