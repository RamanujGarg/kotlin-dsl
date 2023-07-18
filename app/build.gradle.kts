plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
        applicationId = "com.ksr.kotlin_dsl"
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = Dependencies.androidJUnitRunner
    }

    buildTypes {
        getByName(Dependencies.buildFlavour_release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Dependencies.proguard_file),
                Dependencies.proguard_rules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = Version.java
    }
}

dependencies {
    implementation("${Dependencies.core_ktx}:${Version.core_ktx}")
    implementation("${Dependencies.appcompat}:${Version.appcompect}")
    implementation("${Dependencies.material}:${Version.material}")
    implementation("${Dependencies.constraintlayout}:${Version.constraintlayout}")
    testImplementation("${Dependencies.junit}:${Version.junit}")
    androidTestImplementation("${Dependencies.exJunit}:${Version.exJunit}")
    androidTestImplementation("${Dependencies.espressoCore}:${Version.espressoCore}")
}