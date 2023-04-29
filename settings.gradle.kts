@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.4.0")
    id("com.android.settings") version "8.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

extensions.configure<com.android.build.api.dsl.SettingsExtension> {
    buildToolsVersion = "33.0.2"
    compileSdk = 33
    minSdk = 28
}

rootProject.name = "AndroidPlayGround"
include(":app")
include(":compose")
