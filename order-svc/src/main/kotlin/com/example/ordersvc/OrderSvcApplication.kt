package com.example.ordersvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderSvcApplication

fun main(args: Array<String>) {
    runApplication<OrderSvcApplication>(*args)
}
