package com.backcountry.fulfillment.cms.events.handlers

import com.backcountry.fulfillment.cms.events.Event
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
class WireTapHandler : EventHandler<Event> {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Order(100)
    @EventListener
    override fun handle(event: Event) {
        logger.info("The event {} just happened", event)
    }
}