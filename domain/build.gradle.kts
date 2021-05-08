import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("me.zepeto.creator.in_app_game.creator.kotlin-library-conventions")
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

    kotlin("kapt")
    kotlin("plugin.spring") version "1.4.32"
    kotlin("plugin.jpa") version "1.4.32"
    kotlin("plugin.allopen") version "1.4.32"
}

group = "me.zepeto.creator"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
    archiveBaseName.set("in-app-game-creator-domain")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

val generatedQuerydslDir = "$buildDir/generated/source/kapt/main"

querydsl {
    library = "com.querydsl:querydsl-apt"
    jpa = true
    querydslSourcesDir = generatedQuerydslDir
}

sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir(generatedQuerydslDir)
}
