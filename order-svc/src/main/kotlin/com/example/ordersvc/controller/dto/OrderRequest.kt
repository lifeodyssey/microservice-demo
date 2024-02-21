package com.example.ordersvc.controller.dto

data class OrderRequest(
    val orderLineItemsDtoList: List<OrderLineItemsDto>
)
