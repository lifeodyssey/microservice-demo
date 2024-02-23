package com.example.ordersvc.client

import com.example.ordersvc.client.response.InventoryResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "inventory-svc", url = "http:/inventory-service/api/inventory")

interface InventorySvcClient {
    @GetMapping
    fun isInStock(@RequestParam("skuCode") skuCodes: List<String>): List<InventoryResponse>

}
//Feign Client have client side service discovery load balancer in default