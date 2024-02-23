tasks.getByName<Jar>("jar") {
    enabled = false
}
dependencies {
    testImplementation("org.testcontainers:mongodb:1.19.3")

    // mongodb migration
    implementation("io.mongock:mongock-springboot:5.2.2")
    implementation("io.mongock:mongodb-springdata-v4-driver:5.2.1")
    implementation("io.mongock:mongock-springboot-v3:5.2.1")

    //eureka
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.1.0")

}
