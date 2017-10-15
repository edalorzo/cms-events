package com.backcountry.fulfillment.cms.commands

import com.backcountry.fulfillment.cms.commands.api.Command

data class CreateCustomer(
        val email: String,
        val firstName: String,
        val lastName: String
): Command