plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}
dependencies {
    api(libs.javax.inject)
    api(libs.coroutines.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}