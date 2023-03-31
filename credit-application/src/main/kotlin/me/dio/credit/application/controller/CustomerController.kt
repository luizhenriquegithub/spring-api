package me.dio.credit.application.controller

import me.dio.credit.application.dto.CustomerDto
import me.dio.credit.application.dto.CustomerUpdateDto
import me.dio.credit.application.dto.CustomerViewDto
import me.dio.credit.application.entity.Customer
import me.dio.credit.application.service.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val customerService: CustomerService) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved !"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerViewDto {
        val custumer = customerService.findById(id)
        return CustomerViewDto(custumer)
    }

    @DeleteMapping("/id")
    fun deleteCustomer(@PathVariable id: Long) {
        this.customerService.delete(id)
    }

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): CustomerViewDto {
        val customer = this.customerService.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.customerService.save(customerToUpdate)
        return CustomerViewDto(customerUpdated)
    }
}