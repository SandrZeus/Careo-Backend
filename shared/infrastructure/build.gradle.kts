plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(libs.spring.boot.security)
}