package com.backcountry.fulfillment.cms.events.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import java.util.*

@Component
class EventBus @Autowired constructor(private val publisher: ApplicationEventPublisher) {

    fun publishEvent(event: Event) {
        Objects.requireNonNull(event, "The event must not be null")
        publisher.publishEvent(event)
    }

}