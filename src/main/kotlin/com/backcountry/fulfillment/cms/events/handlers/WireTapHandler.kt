package com.backcountry.fulfillment.cms.events.handlers

import com.backcountry.fulfillment.cms.events.Event
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase.AFTER_COMPLETION
import org.springframework.transaction.event.TransactionalEventListener

@Component
class WireTapHandler : EventHandler<Event> {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @TransactionalEventListener(phase = AFTER_COMPLETION)
    override fun handle(event: Event) {
        logger.info("The event {} just happened", event)
    }
}