package com.example.bffsvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class BffSvcApplication

fun main(args: Array<String>) {
    runApplication<BffSvcApplication>(*args)
}