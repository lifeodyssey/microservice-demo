package com.example.ordersvc.service

import com.example.ordersvc.controller.dto.OrderLineItemsDto
import com.example.ordersvc.repository.entity.OrderLineItems

fun OrderLineItemsDto.toOrderLineItems():OrderLineItems=OrderLineItems(
    price = this.price,
    quantity = this.quantity,
    skuCode = this.skuCode
)