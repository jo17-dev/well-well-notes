plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("com.google.devtools.ksp")
}

android {
    namespace = "com.jo17dev.wellwell"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.jo17dev.wellwell"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    val room_version = "2.7.2"
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // adding the real depedencie to room
    implementation("androidx.room:room-runtime:${room_version}")

    // ksp stands for kotlin symbol processing for the entities decorators.. i guess
    ksp("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:${room_version}")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:${room_version}")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:${room_version}")
    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:${room_version}")
}