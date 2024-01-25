tasks.getByName<Jar>("jar") {
    enabled = false
}
dependencies {
    // mysql
    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")
}
