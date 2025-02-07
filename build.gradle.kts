val lombokVersion = "1.18.36"
val postgresqlVersion = "42.7.5"

plugins {
    java
    id("org.springframework.boot") version "3.3.8"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.postgresql:postgresql:$postgresqlVersion")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

sourceSets {
    create("integrationTest") {
        java {
            compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
            runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
        }
    }
}

tasks.register<Test>("integrationTest") {
    description = "Runs the integration tests."
    group = "verification"
    useJUnitPlatform()
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath
}

tasks.withType<Test> {
    useJUnitPlatform()
}