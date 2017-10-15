package com.backcountry.fulfillment.cms.repositories

import com.backcountry.fulfillment.cms.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, String>