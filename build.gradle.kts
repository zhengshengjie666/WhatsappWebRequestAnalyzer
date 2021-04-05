import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

group = "it.auties"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.auties00", "whatsappweb4j", "1.2")
    implementation("org.seleniumhq.selenium", "selenium-java", "4.0.0-beta-2");

}

tasks.withType<JavaCompile> {
    options.forkOptions.jvmArgs?.add("--add-opens")
    options.forkOptions.jvmArgs?.add("jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED")
    options.forkOptions.jvmArgs?.add("--add-opens")
    options.forkOptions.jvmArgs?.add("java.base/java.lang=ALL-UNNAMED")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    options.compilerArgs.plus("--enable-preview")
}

application {
    mainClass.set("MainKt")
}