package com.example.ordersvc.controller

import com.example.ordersvc.controller.dto.OrderRequest
import com.example.ordersvc.service.OrderService
import java.util.concurrent.CompletableFuture
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderService: OrderService) {

    private val log = LoggerFactory.getLogger(OrderController::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun placeOrder(@RequestBody orderRequest: OrderRequest):String {
        log.info("Placing Order")
        return orderService.placeOrder(orderRequest)
    }

}