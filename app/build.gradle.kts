plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":shared:infrastructure"))
    implementation(project(":shared:api"))
    implementation(project(":modules:user"))
    implementation(project(":modules:records"))
    implementation(project(":modules:subscription"))
    implementation(project(":modules:ai"))
    implementation(project(":modules:sync"))

    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.security)
    implementation(libs.spring.boot.actuator)
    implementation(libs.firebase.admin)
    implementation(libs.bundles.jjwt)
    implementation(libs.bundles.flyway)
    runtimeOnly(libs.postgresql)
    developmentOnly(libs.spring.boot.devtools)

    testImplementation(libs.spring.boot.test)
    testImplementation(libs.spring.security.test)
}