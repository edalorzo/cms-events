package com.backcountry.fulfillment.cms.commands.handlers

class CustomerNotFoundException(val email: String): RuntimeException("No customer was found for email $email")