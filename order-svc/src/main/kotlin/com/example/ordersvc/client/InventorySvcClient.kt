package com.example.ordersvc.client

import com.example.ordersvc.client.response.InventoryResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "inventory-svc", url = "http://localhost:8082/api/inventory")

interface InventorySvcClient {
    @GetMapping
    fun isInStock(@RequestParam("skuCode") skuCodes: List<String>): List<InventoryResponse>

}