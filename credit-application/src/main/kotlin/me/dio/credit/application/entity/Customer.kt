package me.dio.credit.application.entity

data class Customer(
    val id: Long? = null,
    var firtName: String = "",
    var lastname: String = "",
    val cpf: String,
    var email: String = "",
    var passowrd: String = "",
    var address: Address = Address(),
    var credits: List<Credit> = mutableListOf()
)
