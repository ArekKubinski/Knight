plugins {
    kotlin("jvm") version "1.9.22"
    id("application")
}

group = "pl.game.terminal"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.shared)
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

application {
    mainClass = "pl.game.terminal.MainKt"
}