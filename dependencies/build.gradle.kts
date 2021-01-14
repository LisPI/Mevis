// This plugin used to store information about dependencies to avoid using buildSrc
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    }
}

plugins {
    kotlin("jvm") version "1.4.21"
    id("java-gradle-plugin")
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDir("src/main/kotlin")
    }
}

repositories {
    jcenter()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
}

gradlePlugin {
    plugins {
        create("dependencies") {
            id = "com.epam.android.swimmer.gradle.plugin.dependencies"
            implementationClass = "com.epam.android.swimmer.gradle.plugin.DependenciesPlugin"
        }
    }
}