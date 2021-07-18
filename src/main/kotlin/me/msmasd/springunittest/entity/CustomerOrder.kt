package me.msmasd.springunittest.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class CustomerOrder {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    lateinit var orderDateTime: LocalDateTime

    @Column(nullable = false)
    lateinit var address: String

    @Column(nullable = false)
    var isGiftPackaging: Boolean? = null

    lateinit var memo: String

    @OneToOne
    @JoinColumn(
        name = "customer_id",
        foreignKey = ForeignKey(name = "FK_ORDER_CUSTOMER", value = ConstraintMode.CONSTRAINT)
    )
    lateinit var customer: Customer

    @OneToMany(mappedBy = "customerOrder", cascade = [CascadeType.ALL], orphanRemoval = true)
    var products: MutableList<OrderProductMap>? = null

    fun addProduct(product: Product) {
        if (this.products == null) {
            this.products = mutableListOf()
        }
        this.products?.add(OrderProductMap(this, product))
    }

}