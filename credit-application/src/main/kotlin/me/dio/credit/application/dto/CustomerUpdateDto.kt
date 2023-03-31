package me.dio.credit.application.dto

import me.dio.credit.application.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firtName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firtName = this.firtName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
