package me.dio.credit.application.service.impl

import me.dio.credit.application.entity.Credit
import me.dio.credit.application.repository.CreditRepository
import me.dio.credit.application.service.CreditService
import me.dio.credit.application.service.CustomerService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditServiceImpl(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : CreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit =
            creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode $creditCode not found")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}