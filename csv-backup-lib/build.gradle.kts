plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    //id("com.google.devtools.ksp") version "2.0.21-1.0.22"  // これを追加
    //alias(libs.plugins.ksp)
    id("com.google.devtools.ksp") version "2.0.0-1.0.22"
    //kotlin("ksp")
    //id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.github.ttt374.csv_backup_lib"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //add("ksp", "com.google.devtools.ksp:symbol-processing-api:2.0.21-1.0.22")

    // hilt
    implementation("com.google.dagger:hilt-android:2.52")
    ksp("com.google.dagger:hilt-compiler:2.51")

    // opencsv
    implementation("com.opencsv:opencsv:5.9")
}