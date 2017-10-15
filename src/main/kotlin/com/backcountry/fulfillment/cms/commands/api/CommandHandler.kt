package com.backcountry.fulfillment.cms.commands.api

interface CommandHandler<in T> where T: Command {
    
    fun handle(command: T)
}