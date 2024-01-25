package com.example.productsvc.repository

import com.example.productsvc.repository.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product?, String?>
