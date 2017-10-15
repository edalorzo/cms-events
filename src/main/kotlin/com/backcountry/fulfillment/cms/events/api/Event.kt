package com.backcountry.fulfillment.cms.events.api

import com.fasterxml.jackson.annotation.JsonIgnore

interface Event {

    @JsonIgnore
    fun getRoutingKey(): String

}