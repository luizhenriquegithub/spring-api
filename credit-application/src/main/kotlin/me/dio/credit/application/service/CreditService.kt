package me.dio.credit.application.service

import me.dio.credit.application.entity.Credit
import java.util.UUID

interface CreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long ,creditCode: UUID): Credit
}