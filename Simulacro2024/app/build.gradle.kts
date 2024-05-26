plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "com.example.simulacros"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.simulacros"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.legacy.support.v4)

    //NavGraph
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)

    //Ksp o kasp
    implementation(libs.com.google.devtools.ksp.gradle.plugin)

    //Hilt & Dagger
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    //Room
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    //Glide
    implementation(libs.glide)
    implementation(libs.hilt.android.gradle.plugin)

    //Navigation Drawer
    implementation(libs.androidx.drawerlayout)

    //Retrofit & OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.fragment.ktx)

    //Preference Screen
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.preference)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}