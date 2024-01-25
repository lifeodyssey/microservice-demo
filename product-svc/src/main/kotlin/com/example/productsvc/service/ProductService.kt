package com.example.productsvc.service

import com.example.productsvc.controller.dto.ProductRequest
import com.example.productsvc.controller.dto.ProductResponse
import com.example.productsvc.repository.ProductRepository
import com.example.productsvc.repository.entity.Product
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    private val log = LoggerFactory.getLogger(ProductService::class.java)

    fun createProduct(productRequest: ProductRequest) {
        val product = Product(
            name = productRequest.name,
            description = productRequest.description,
            price = productRequest.price
        )

        productRepository.save(product)
        log.info("Product {} is saved", product.id)
    }

    fun getAllProducts(): List<ProductResponse> {
        return productRepository.findAll().map { mapToProductResponse(it!!) }
    }

    private fun mapToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id!!,
            name = product.name,
            description = product.description,
            price = product.price
        )
    }
}
