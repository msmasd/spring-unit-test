package me.msmasd.springunittest.service

import me.msmasd.springunittest.entity.Customer
import me.msmasd.springunittest.entity.CustomerOrder
import me.msmasd.springunittest.entity.Product
import me.msmasd.springunittest.respository.CustomerOrderRepository
import me.msmasd.springunittest.respository.CustomerRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import javax.servlet.http.HttpSession

@ExtendWith(MockitoExtension::class)
internal class CustomerServiceTest {
    @Mock
    private lateinit var httpSession: HttpSession

    @Mock
    private lateinit var customerOrderRepository: CustomerOrderRepository

    @Mock
    private lateinit var customerRepository: CustomerRepository

    @InjectMocks
    private lateinit var customerService: CustomerService


    @Test
    fun `findMyOrderPriceSum 로그인 사용자의 주문상품금액합계가 반환된다`() {
        // given
        val customer = Customer()

        given(httpSession.getAttribute("loginUser"))
            .willReturn(customer)

        val order = CustomerOrder()

        order.addProduct(Product()
            .apply { price = 10000L }
        )

        order.addProduct(Product()
            .apply { price = 15000L }
        )

        given(customerOrderRepository.findAllByCustomer(customer))
            .willReturn(listOf(order))

        // when
        val sum = customerService.findMyOrderPriceSum()

        // then
        Assertions.assertThat(sum).isEqualTo(25000L)
    }

    @Test
    fun `fundByName 찾는 고객이 없으면 RuntimeException 발생`() {
        val name = "msmasd"
        given(customerRepository.findCustomerByName(name))
            .willReturn(null)

        Assertions.assertThatThrownBy { customerService.findByName(name) }
            .isInstanceOf(RuntimeException::class.java)

        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { customerService.findByName(name) }

    }
}