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
    val sendSafelyVersion = "3.1.7"
    val commonsCollectionsVersion = "4.4"

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
    implementation("com.sendsafely:sendsafely-java-api:$sendSafelyVersion")
    implementation("org.springframework.boot:spring-boot-starter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.apache.commons:commons-collections4:$commonsCollectionsVersion")
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