plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("kotlin-kapt")

}

android {
    namespace = "com.example.recipes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.recipes"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // sign in
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")

    // gson
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.airbnb.android:lottie:6.6.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.squareup.picasso:picasso:2.8")
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

        val lifecycle_version = "2.8.7"
        val arch_version = "2.2.0"

        // ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
        kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")
        implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")
        testImplementation("androidx.arch.core:core-testing:$arch_version")
        testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")



}