package com.example.inventorysvc.controller.dto

data class InventoryResponse(
    val skuCode: String,
    val isInStock: Boolean
)
