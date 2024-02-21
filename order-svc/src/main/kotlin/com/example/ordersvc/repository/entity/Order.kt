package com.example.ordersvc.repository.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "t_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var orderNumber: String? = null,
    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    var orderLineItemsList: List<OrderLineItems> = mutableListOf()
)
