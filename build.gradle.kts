plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("de.m3y.kformat:kformat:0.11")
    implementation("com.github.ajalt.clikt:clikt:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}