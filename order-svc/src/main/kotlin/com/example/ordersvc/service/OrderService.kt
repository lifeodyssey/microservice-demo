package com.example.ordersvc.service

import com.example.ordersvc.controller.dto.OrderLineItemsDto
import com.example.ordersvc.controller.dto.OrderRequest
import com.example.ordersvc.repository.OrderRepository
import com.example.ordersvc.repository.entity.Order
import com.example.ordersvc.repository.entity.OrderLineItems
import java.util.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository,
) {


    fun placeOrder(orderRequest: OrderRequest) {
        val order = Order().apply {
            orderNumber = UUID.randomUUID().toString()
            orderLineItemsList = orderRequest.orderLineItemsDtoList.map { it.toOrderLineItems() }
        }
        orderRepository.save(order)

    }

}
