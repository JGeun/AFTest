plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Configuration.javaVersion
        targetCompatibility = Configuration.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:common-ui"))

    implementation(Dependencies.navigation.fragment)
    implementation(Dependencies.navigation.ui)

    implementation(Dependencies.lifecycle.viewModel)

    implementation(Dependencies.kotlin.coroutine)

    implementation(Dependencies.hilt.android)
    kapt(Dependencies.hilt.compiler)

    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glide.compiler)

    testImplementation(Dependencies.test.jUnit)
    androidTestImplementation(Dependencies.test.jUnitExt)
    androidTestImplementation(Dependencies.test.expresso)
}