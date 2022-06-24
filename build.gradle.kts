import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("java")
    id("com.diffplug.spotless") version "6.6.1"
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "io.github.craigmiller160"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.8.2"
    val sendSafelyVersion = "3.1.7"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("com.sendsafely:sendsafely-java-api:$sendSafelyVersion")
    implementation("org.springframework.boot:spring-boot-starter")
    compileOnly("org.projectlombok:lombok")

}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}

configure<SpotlessExtension> {
    java {
        googleJavaFormat()
    }
}