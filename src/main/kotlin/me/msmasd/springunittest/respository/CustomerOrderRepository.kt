package me.msmasd.springunittest.respository

import me.msmasd.springunittest.entity.Customer
import me.msmasd.springunittest.entity.CustomerOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerOrderRepository : JpaRepository<CustomerOrder, Long> {
    fun findAllByCustomer(customer: Customer): List<CustomerOrder>
}