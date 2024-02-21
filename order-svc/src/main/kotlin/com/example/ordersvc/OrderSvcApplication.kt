package com.example.ordersvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class OrderSvcApplication

fun main(args: Array<String>) {
    runApplication<OrderSvcApplication>(*args)
}
