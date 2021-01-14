import com.epam.android.swimmer.gradle.plugin.DependenciesPlugin.Dependencies

plugins {
    id("com.epam.android.swimmer.gradle.plugin.dependencies")
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.4.21"
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("de.mannodermaus.android-junit5")
}

repositories {
    maven("https://dl.bintray.com/kirich1409/maven")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.epam.android.swimmer"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = Dependencies.Androidx.Test.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
    sourceSets.forEach {
        it.java.srcDir("src/${it.name}/kotlin")
    }

//    testOptions {
//        junitPlatform {
//            filters {
//                engines {
//                    include("spek2")
//                }
//            }
//            jacocoOptions {
//                html.enabled = true
//                xml.enabled = false
//                csv.enabled = false
//            }
//        }
//        unitTests.all {
//            testLogging.events = ["passed", "skipped", "failed"]
//        }
//    }
}

dependencies {
    implementation(project(":retrofit-result"))
    implementation(Dependencies.Androidx.CORE_KTX)
    implementation(Dependencies.Androidx.APPCOMPAT)
    implementation(Dependencies.Theme.MATERIAL)
    implementation(Dependencies.Androidx.CONSTRAINT_LAYOUT)

    implementation(Dependencies.Androidx.RECYCLER_VIEW)
    implementation(Dependencies.Androidx.FRAGMENT)
    implementation(Dependencies.Androidx.PREFERENCE)

    implementation(Dependencies.Androidx.Lifecycle.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.Androidx.Lifecycle.LIFECYCLE_VIEWMODEL)

    implementation(Dependencies.Androidx.Navigation.NAVIGATION_FRAGMENT)
    implementation(Dependencies.Androidx.Navigation.NAVIGATION_UI)
    implementation(Dependencies.Androidx.Navigation.NAVIGATION_DYNAMIC_FEATURES)

    implementation(Dependencies.Androidx.Room.ROOM_RUNTIME)
    kapt(Dependencies.Androidx.Room.ROOM_COMPILER)
    implementation(Dependencies.Androidx.Room.ROOM_KTX)

    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_KAPT)
    implementation(Dependencies.Hilt.HILT_VIEW_MODEL)
    kapt(Dependencies.Hilt.HILT_KAPT_ANDROIDX)

    implementation(Dependencies.Kotlin.Coroutines.COROUTINES_CORE)
    implementation(Dependencies.Kotlin.Coroutines.COROUTINES_ANDROID)
    implementation(Dependencies.Kotlin.Serialization.SERIALIZATION_CORE)

    implementation(Dependencies.Network.COIL)
    implementation(Dependencies.Network.INTERSEPTOR)
    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.SERIALIZATION_CONVERTER)

    implementation(Dependencies.VIEW_BINDING_PROPERTY_DELEGATE)
    implementation(Dependencies.TIMBER)

    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.MOCKK)
    androidTestImplementation(Dependencies.Androidx.Test.JUNIT)
    androidTestImplementation(Dependencies.Androidx.Test.ESPRESSO_CORE)

    implementation(Dependencies.Kotlin.KOTLIN_STD_LIB_JDK8)
    testImplementation(Dependencies.Kotlin.KOTLIN_REFLECT)
    testImplementation(Dependencies.Test.Spek.SPEK_DSL_JVM)
    testImplementation(Dependencies.Test.Spek.SPEK_RUNNER_JUNIT5)
    testImplementation (Dependencies.Kotlin.Coroutines.COROUTINES_TEST)
}