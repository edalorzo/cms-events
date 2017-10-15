package com.backcountry.fulfillment.cms.commands.api

interface CommandHandler<T> where T: Command {
    
    fun handle(command: T)
}