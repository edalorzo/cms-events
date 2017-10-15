package com.backcountry.fulfillment.cms.events.handlers

import com.backcountry.fulfillment.cms.events.Event

interface EventHandler<T> where T: Event{

    fun handle(event: T);

}