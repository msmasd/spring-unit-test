package me.msmasd.springunittest.service

import me.msmasd.springunittest.entity.Customer
import me.msmasd.springunittest.entity.OrderProductMap
import me.msmasd.springunittest.respository.CustomerOrderRepository
import me.msmasd.springunittest.respository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.http.HttpSession

@Service
class CustomerService(
    private val httpSession: HttpSession,
    private val customerOrderRepository: CustomerOrderRepository,
    private val customerRepository: CustomerRepository,
) {

    @Transactional(readOnly = true)
    fun findMyOrderPriceSum(): Long {
        // 1. 세션에서 로그인한 사용자 조회
        val customer = httpSession.getAttribute("loginUser") as Customer

        // 2. 사용자정보로 주문정보 조회
        // 3. 주문정보에서 product 조회
        // 4. product 들의 합 계산
        return customerOrderRepository.findAllByCustomer(customer)
            .sumOf { sum(it.products) }
    }

    private fun sum(orderProduct: MutableList<OrderProductMap>?): Long {
        return orderProduct?.sumOf { it.product.price } ?: 0L
    }

    @Transactional(readOnly = true)
    fun findByName(name: String): Customer {
        return customerRepository.findCustomerByName(name)
            ?: throw RuntimeException("해당 고객정보는 존재하지 않습니다: $name")
    }
}