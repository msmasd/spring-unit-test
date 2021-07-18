package me.msmasd.springunittest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringUnitTestApplication

fun main(args: Array<String>) {
    runApplication<SpringUnitTestApplication>(*args)
}
