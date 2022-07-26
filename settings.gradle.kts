pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("bla-bla")
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "Beauty"
include(":app", ":common", ":core", ":feature-business")
enableFeaturePreview("VERSION_CATALOGS")