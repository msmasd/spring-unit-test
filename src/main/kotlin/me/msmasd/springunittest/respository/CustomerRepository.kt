package me.msmasd.springunittest.respository

import me.msmasd.springunittest.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findCustomerByName(name: String): Customer?
}