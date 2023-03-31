package me.dio.credit.application.dto

import me.dio.credit.application.entity.Address
import me.dio.credit.application.entity.Customer
import java.math.BigDecimal

data class CustomerDto(
    val firtName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firtName = this.firtName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        passowrd = this.password,
        address = Address(zipCode = this.zipCode,street = this.street)
    )
}
