package me.msmasd.springunittest.entity

import javax.persistence.*

@Entity
class OrderProductMap(
    @ManyToOne
    @JoinColumn(name = "customer_order_id", foreignKey = ForeignKey(name = "FK_CUSTOMER_ORDER_MAP"))
    var customerOrder: CustomerOrder,

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = ForeignKey(name = "FK_PRODUCT_MAP"))
    var product: Product,
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}