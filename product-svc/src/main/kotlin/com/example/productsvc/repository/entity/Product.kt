package com.example.productsvc.repository.entity

import java.math.BigDecimal
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class Product(
    @Id
    val id: String? = null,
    val name: String,
    val description: String,
    val price: BigDecimal
)