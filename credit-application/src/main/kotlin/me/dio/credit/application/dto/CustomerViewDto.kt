package me.dio.credit.application.dto

import me.dio.credit.application.entity.Customer
import java.math.BigDecimal

data class CustomerViewDto(
    val firtName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String

) {
    constructor( customer: Customer) : this(
        firtName = customer.firtName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}
