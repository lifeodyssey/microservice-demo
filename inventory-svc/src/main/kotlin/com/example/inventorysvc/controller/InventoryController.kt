package com.example.inventorysvc.controller

import com.example.inventorysvc.controller.dto.InventoryResponse
import com.example.inventorysvc.service.InventoryService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inventory")
class InventoryController(private val inventoryService: InventoryService) {

    private val log = LoggerFactory.getLogger(InventoryController::class.java)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun isInStock(@RequestParam skuCode: List<String>): List<InventoryResponse> {
        log.info("Received inventory check request for skuCode: {}", skuCode)
        return inventoryService.isInStock(skuCode)
    }
}