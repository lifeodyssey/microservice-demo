package com.example.inventorysvc

import com.example.inventorysvc.controller.dto.InventoryResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class InventorySvcApplicationTests {

    @Test
    fun contextLoads() {
    }

    companion object {
        @JvmStatic
        @Container
        val mySQLContainer = MySQLContainer("mysql:8.0.26").apply {
            withDatabaseName("inventory_service")
            withUsername("root")
            withPassword("mysql")
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun setProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { mySQLContainer.jdbcUrl }
            registry.add("spring.datasource.username") { mySQLContainer.username }
            registry.add("spring.datasource.password") { mySQLContainer.password }
            registry.add("spring.datasource.driver-class-name") { mySQLContainer.driverClassName }
        }
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `test isInStock`() {
        val skuCodes = listOf("xiaomi_14_black", "xiaomi_14_snowy_mountain_pink")

        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/inventory")
                .param("skuCode", *skuCodes.toTypedArray())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo { result ->
                val inventoryList: List<InventoryResponse> = objectMapper.readValue(result.response.contentAsString)
                assertEquals(2, inventoryList.size)
                assertEquals(true, inventoryList.find { it.skuCode == "xiaomi_14_black" }?.isInStock)
                assertEquals(false, inventoryList.find { it.skuCode == "xiaomi_14_snowy_mountain_pink" }?.isInStock)
            }
    }
}
