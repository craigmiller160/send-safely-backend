import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("java")
    id("com.diffplug.spotless") version "6.6.1"
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
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
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