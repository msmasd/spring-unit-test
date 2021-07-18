package me.msmasd.springunittest.entity

import javax.persistence.*

@Table
@Entity
class Customer(
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var email: String

    @Column(nullable = false)
    lateinit var mobileNumber: String
}