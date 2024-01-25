package com.example.inventorysvc.service

import com.example.inventorysvc.controller.dto.InventoryResponse
import com.example.inventorysvc.repository.InventoryRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InventoryService(private val inventoryRepository: InventoryRepository) {

    private val log = LoggerFactory.getLogger(InventoryService::class.java)

    @Transactional(readOnly = true)
    fun isInStock(skuCode: List<String>): List<InventoryResponse> {
        log.info("Checking Inventory")
        return inventoryRepository.findBySkuCodeIn(skuCode).map { inventory ->
            InventoryResponse(
                skuCode = inventory.skuCode,
                isInStock = inventory.quantity > 0
            )
        }
    }
}