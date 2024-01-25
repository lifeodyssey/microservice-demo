package com.example.productsvc.utils

import com.example.productsvc.repository.ProductRepository
import com.example.productsvc.repository.entity.Product
import java.math.BigDecimal
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(private val productRepository: ProductRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (productRepository.count() == 0L) {
            val product = Product(
                name = "Xiaomi14",
                description = "Xiaomi14",
                price = BigDecimal.valueOf(4599)
            )

            productRepository.save(product)
        }
    }
}