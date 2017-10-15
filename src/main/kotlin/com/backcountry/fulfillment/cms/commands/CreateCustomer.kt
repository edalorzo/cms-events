package com.backcountry.fulfillment.cms.commands

class CreateCustomer(
        val email: String,
        val firstName: String,
        val lastName: String
): Command