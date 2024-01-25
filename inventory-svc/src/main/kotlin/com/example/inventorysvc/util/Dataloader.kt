package com.example.inventorysvc.util

import com.example.inventorysvc.repository.InventoryRepository
import com.example.inventorysvc.repository.entity.Inventory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(private val inventoryRepository: InventoryRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val inventory = Inventory(skuCode = "xiaomi_14_black", quantity = 999)
        val inventory1 = Inventory(skuCode = "xiaomi_14_snowy_mountain_pink", quantity = 666)

        inventoryRepository.save(inventory)
        inventoryRepository.save(inventory1)
    }
}