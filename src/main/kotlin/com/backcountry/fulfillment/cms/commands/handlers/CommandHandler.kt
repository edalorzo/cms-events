package com.backcountry.fulfillment.cms.commands.handlers

import com.backcountry.fulfillment.cms.commands.Command

interface CommandHandler<T> where T: Command {
    
    fun handle(command: T)
}