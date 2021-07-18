package me.msmasd.springunittest.respository

import me.msmasd.springunittest.entity.OrderProductMap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderProductMapRepository : JpaRepository<OrderProductMap, Long> {
}