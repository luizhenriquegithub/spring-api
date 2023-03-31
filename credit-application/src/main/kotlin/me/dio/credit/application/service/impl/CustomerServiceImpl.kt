package me.dio.credit.application.service.impl

import me.dio.credit.application.entity.Customer
import me.dio.credit.application.repository.CustomerRepository
import me.dio.credit.application.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
): CustomerService {
    override fun save(customer: Customer): Customer =
        customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found")
        }

    override fun delete(id: Long) = customerRepository.deleteById(id)
}