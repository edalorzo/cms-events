package com.backcountry.fulfillment.cms.events.api

interface EventHandler<T> where T: Event {

    fun handle(event: T);

}