tasks.getByName<Jar>("jar") {
    enabled = false
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:4.0.0")
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.3")
}
