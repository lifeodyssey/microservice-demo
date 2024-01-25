package com.example.inventorysvc.repository

import com.example.inventorysvc.repository.entity.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : JpaRepository<Inventory, Long> {
    fun findBySkuCodeIn(skuCode: List<String>): List<Inventory>
}
