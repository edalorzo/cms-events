package com.backcountry.fulfillment.cms.model

import com.backcountry.fulfillment.cqrs.commands.cms.ActivateCustomer
import com.backcountry.fulfillment.cqrs.commands.cms.ChangePassword
import com.backcountry.fulfillment.cqrs.commands.cms.CreateCustomer
import com.backcountry.fulfillment.cqrs.commands.cms.DeactivateCustomer
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
class Customer(
        @Id @Column(name="cust_email") var email: String,
        @Column(name="cust_fname") var firstName: String,
        @Column(name="cust_lname") var lastName: String,
        @Column(name="cust_password") var password: String? = null,
        @Column(name="cust_active") var active: Boolean = false) {

    constructor(command: CreateCustomer):this(
            command.email,
            command.firstName,
            command.lastName
    )

    fun execute(command: ChangePassword): Customer {

        if(command.email != this.email)
            throw IllegalArgumentException("Invalid command: " + command)

        this.password = command.password
        return this
    }

    fun execute(command: ActivateCustomer): Customer {
        if(command.email != this.email)
            throw IllegalArgumentException("Invalid command: " + command)
        this.active = true
        return this
    }

    fun execute(command: DeactivateCustomer): Customer {
        if(command.email != this.email)
            throw IllegalArgumentException("Invalid command: " + command)
        this.active = false
        return this
    }

}