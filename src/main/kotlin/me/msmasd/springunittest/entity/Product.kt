package me.msmasd.springunittest.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Product {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    var price: Long = 0L

    @Column(nullable = false)
    lateinit var manufactureDate: LocalDate
}