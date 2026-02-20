import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	alias(libs.plugins.kotlin.jvm) apply false
	alias(libs.plugins.kotlin.spring) apply false
	alias(libs.plugins.kotlin.jpa) apply false
	alias(libs.plugins.spring.boot) apply false
	alias(libs.plugins.spring.dependency.management) apply false
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "io.spring.dependency-management")

	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/milestone") }
	}

	configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:3.4.3")
			mavenBom("org.springframework.ai:spring-ai-bom:1.0.0-M6")
		}
	}

	configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
		jvmToolchain(21)
	}

	dependencies {
		"implementation"("org.jetbrains.kotlin:kotlin-reflect")
		"implementation"("com.fasterxml.jackson.module:jackson-module-kotlin")
		"implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core")
		"implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		"testImplementation"("io.mockk:mockk:1.14.9")
		"testImplementation"("org.jetbrains.kotlin:kotlin-test-junit5")
		"testRuntimeOnly"("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<KotlinCompile>().configureEach {
		compilerOptions {
			freeCompilerArgs.add("-Xjsr305=strict")
			jvmTarget.set(JvmTarget.JVM_21)
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}