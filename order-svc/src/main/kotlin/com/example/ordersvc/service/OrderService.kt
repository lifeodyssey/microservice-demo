package com.example.ordersvc.service

import com.example.ordersvc.client.InventorySvcClient
import com.example.ordersvc.controller.dto.OrderRequest
import com.example.ordersvc.repository.OrderRepository
import com.example.ordersvc.repository.entity.Order
import java.util.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository,
    private val inventorySvcClient: InventorySvcClient
) {

    fun placeOrder(orderRequest: OrderRequest): String {
        val order = Order().apply {
            orderNumber = UUID.randomUUID().toString()
            orderLineItemsList = orderRequest.orderLineItemsDtoList.map { it.toOrderLineItems() }
        }
        val skuList = order.orderLineItemsList.map { it.skuCode!! }
        val inventoryResponseList = inventorySvcClient.isInStock(skuList)
        val allProductsInStock = inventoryResponseList.all { it.isInStock }
        if (allProductsInStock) {
            orderRepository.save(order)
            return "Order Placed"
        } else {
            throw IllegalArgumentException("Product is not in stock, please try again later")
        }
    }

}
