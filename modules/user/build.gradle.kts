plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.jpa)
    implementation(libs.spring.boot.validation)
    runtimeOnly(libs.postgresql)
}