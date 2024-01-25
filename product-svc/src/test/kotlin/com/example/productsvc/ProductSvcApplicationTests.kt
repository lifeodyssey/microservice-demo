package com.example.productsvc

import com.example.productsvc.controller.dto.ProductRequest
import com.example.productsvc.repository.ProductRepository
import com.fasterxml.jackson.databind.ObjectMapper
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
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import java.math.BigDecimal
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureMockMvc
class ProductSvcApplicationTests {

    @Test
    fun contextLoads() {
    }

    companion object {
        @JvmStatic
        @Container
        val mongoDBContainer = MongoDBContainer("mongo:4.4.2").apply {
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun setProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri") { mongoDBContainer.replicaSetUrl }
        }
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun shouldCreateProduct() {
        val productRequest = getProductRequest()
        val productRequestString = objectMapper.writeValueAsString(productRequest)
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productRequestString)
        )
            .andExpect(status().isCreated)
        assertEquals(2, productRepository.findAll().size)
    }

    private fun getProductRequest(): ProductRequest {
        return ProductRequest(
            name = "Xiaomi14",
            description = "Xiaomi14",
            price = BigDecimal.valueOf(4599)
        )
    }
}
