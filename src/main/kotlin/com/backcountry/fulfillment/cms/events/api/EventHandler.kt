package com.backcountry.fulfillment.cms.events.api

interface EventHandler<in T> where T: Event {

    fun handle(event: T)

}