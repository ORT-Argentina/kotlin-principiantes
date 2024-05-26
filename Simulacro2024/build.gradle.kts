// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.safeargs) apply false
    alias(libs.plugins.hilt) apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath(libs.hilt.android.gradle.plugin)
        //classpath(libs.hilt.android.plugin)
    }
}

//spotless {
//    kotlin {
//        target("**/*.kt")
//        ktlint(ktlintVersion).userData(['max_line_length': '100'])
//    }
//}