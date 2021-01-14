buildscript {
    val kotlin_version by extra("1.4.21")
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.30.1-alpha")
        classpath ("de.mannodermaus.gradle.plugins:android-junit5:1.7.0.0")
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    ktlint {
        debug.set(false)
    }

    val detekt by tasks
    val ktlintCheck by tasks
    tasks.register("codeStyleCheck") {
        group = "verification"
        description = "Combined codestyle checks"
        dependsOn(detekt, ktlintCheck)
    }

    detekt {
        toolVersion = "1.10.0"
        input = files(
                "src/main/kotlin"
        )
        parallel = false
        config = files("$rootDir/config/detekt/detekt.yml")
        buildUponDefaultConfig = false
        disableDefaultRuleSets = false
        debug = false
        ignoreFailures = false
        reports {
            xml {
                enabled = false
            }
            html {
                enabled = false
            }
            txt {
                enabled = true
                destination = file("build/reports/detekt.txt")
            }
        }
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}