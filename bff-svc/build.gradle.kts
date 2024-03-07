tasks.getByName<Jar>("jar") {
    enabled = false
}

dependencies {

    //eureka
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.1.0")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:4.1.0")

}
