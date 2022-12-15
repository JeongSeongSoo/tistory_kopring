import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.6"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	google()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-devtools:2.7.6")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// 2022.12.12[프뚜]: Retrofit 라이브러리
	implementation("com.squareup.retrofit2:retrofit:2.9.0")

	// 2022.12.12[프뚜]: Gson 변환기 라이브러리
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
