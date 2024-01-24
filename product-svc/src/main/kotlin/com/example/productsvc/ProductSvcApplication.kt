package com.example.productsvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductSvcApplication

fun main(args: Array<String>) {
    runApplication<ProductSvcApplication>(*args)
}
