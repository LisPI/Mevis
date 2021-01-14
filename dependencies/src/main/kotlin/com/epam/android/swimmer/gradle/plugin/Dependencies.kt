package com.epam.android.swimmer.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Possibly common dependencies or can stay empty
    }

    companion object Dependencies {
        private const val kotlinVersion = "1.4.21"

        const val TIMBER = "com.jakewharton.timber:timber:4.7.1"
        const val VIEW_BINDING_PROPERTY_DELEGATE =
                "com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:1.2.1"

        object Theme {
            const val MATERIAL = "com.google.android.material:material:1.2.1"
        }

        object Kotlin {
            const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
            const val KOTLIN_STD_LIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
            const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"

            object Serialization {
                const val SERIALIZATION_CORE = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
            }

            object Coroutines {
                const val COROUTINES_CORE =
                        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1"
                const val COROUTINES_ANDROID =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
                const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
            }
        }

        object Hilt {
            private const val hiltVersion = "2.30.1-alpha"
            private const val hiltAndroidxVersion = "1.0.0-alpha02"
            const val HILT_ANDROID = "com.google.dagger:hilt-android:$hiltVersion"
            const val HILT_KAPT = "com.google.dagger:hilt-android-compiler:$hiltVersion"
            const val HILT_KAPT_ANDROIDX = "androidx.hilt:hilt-compiler:$hiltAndroidxVersion"
            const val HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidxVersion"
        }

        object Network {
            const val COIL = "io.coil-kt:coil:1.1.1"
            const val INTERSEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.0"
            const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
            const val SERIALIZATION_CONVERTER =
                    "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        }

        object Test {
            const val JUNIT = "junit:junit:4.13.1"
            const val MOCKK = "io.mockk:mockk:1.10.4"

            object Spek {
                private const val SPEK_VERSION = "2.0.15"

                const val SPEK_DSL_JVM =
                        "org.spekframework.spek2:spek-dsl-jvm:$SPEK_VERSION"
                const val SPEK_RUNNER_JUNIT5 =
                        "org.spekframework.spek2:spek-runner-junit5:$SPEK_VERSION"
            }
        }

        object Androidx {
            const val CORE_KTX = "androidx.core:core-ktx:1.3.1"
            const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"

            const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.1.0"
            const val FRAGMENT = "androidx.fragment:fragment-ktx:1.2.5"
            const val PREFERENCE = "androidx.preference:preference:1.1.1"

//            const val SECURITY_CRYPTO = "androidx.security:security-crypto:1.0.0-rc03"

            object Lifecycle {
                private const val LIFECYCLE_VERSION = "2.2.0"
                const val LIFECYCLE_EXTENSIONS =
                        "androidx.lifecycle:lifecycle-extensions:$LIFECYCLE_VERSION"
                const val LIFECYCLE_VIEWMODEL =
                        "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
            }

            object Navigation {
                private const val NAVIGATION_VERSION = "2.3.2"

                const val NAVIGATION_FRAGMENT =
                        "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
                const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
                const val NAVIGATION_DYNAMIC_FEATURES =
                        "androidx.navigation:navigation-dynamic-features-fragment:$NAVIGATION_VERSION"
            }

            object Room {
                private const val ROOM_VERSION = "2.2.5"
                const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
                const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
                const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VERSION"
            }

            object Test {
                const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
                const val JUNIT = "androidx.test.ext:junit:1.1.2"
                const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.3.0"
            }
        }
    }
}