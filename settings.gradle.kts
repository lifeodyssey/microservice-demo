plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "microservice-demo"
include(":product-svc")
include(":inventory-svc")
include(":order-svc")
include(":discovery-svc")
include("bff-svc")
