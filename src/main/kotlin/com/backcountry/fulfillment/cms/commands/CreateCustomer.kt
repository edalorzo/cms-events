package com.backcountry.fulfillment.cms.commands

data class CreateCustomer(
        val email: String,
        val firstName: String,
        val lastName: String
): Command