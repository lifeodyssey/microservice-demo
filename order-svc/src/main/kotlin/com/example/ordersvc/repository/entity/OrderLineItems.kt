package com.example.ordersvc.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal


@Entity
@Table(name = "t_order_line_items")
data class OrderLineItems(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var skuCode: String? = null,
    var price: BigDecimal? = null,
    var quantity: Int? = null
)
