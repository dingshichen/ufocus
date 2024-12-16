import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.springframework.boot") version "2.7.16"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    kotlin("plugin.lombok") version "2.1.0"
    id("io.freefair.lombok") version "8.10"
}

group = "cn.dsc"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    maven {
        setUrl("https://repo.huaweicloud.com/repository/maven/")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/public")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/central")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/jcenter")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/google")
    }
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter")
    }
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/repositories/releases")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/apache-snapshots")
    }
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.9")
    implementation("com.baomidou:mybatis-plus-jsqlparser-4.9:3.5.9")
    implementation("javax.validation:validation-api")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
