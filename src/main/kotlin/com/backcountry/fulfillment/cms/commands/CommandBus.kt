package com.backcountry.fulfillment.cms.commands

import com.backcountry.fulfillment.cqrs.commands.api.Command
import com.backcountry.fulfillment.cqrs.commands.api.RemoteCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import java.util.*

@Component
class CommandBus @Autowired constructor(private val publisher: ApplicationEventPublisher) {

    fun publishCommand(command: Command) {
        Objects.requireNonNull(command, "The command must not be null")
        publisher.publishEvent(command)
    }

    fun publishCommand(commnd: RemoteCommand) {
        //TODO send the remote command
    }

}