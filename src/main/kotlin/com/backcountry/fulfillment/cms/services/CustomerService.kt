package com.backcountry.fulfillment.cms.services

import com.backcountry.fulfillment.cms.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired val customerRepository: CustomerRepository) {



}