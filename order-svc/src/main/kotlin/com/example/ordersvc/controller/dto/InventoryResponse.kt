package com.example.ordersvc.controller.dto

data class InventoryResponse(
    val skuCode: String,
    val isInStock: Boolean
)
