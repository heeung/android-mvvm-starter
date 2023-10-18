plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.kapt")
    id ("kotlin-parcelize")
    id ("dagger.hilt.android.plugin")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.mvvmstarter"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mvvmstarter"
        minSdk = 24
        targetSdk = 33
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
    viewBinding {
        enable = true
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.3.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // okhttp
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.activity:activity-ktx:1.7.2")

    //liveData
//    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    //framework ktx
    implementation ("androidx.fragment:fragment-ktx:1.6.0")

    // Jetpack Navigation Kotlin
    val nav_version = "2.4.2"
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    // material ui
    implementation ("com.google.android.material:material:1.5.0")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    //hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")

    //room
    val room_version = "2.4.3"
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")

//    //카카오 로그인
//    implementation ("com.kakao.sdk:v2-all:2.16.0") // 전체 모듈 설치, 2.11.0 버전부터 지원
//    implementation ("com.kakao.sdk:v2-user:2.16.0") // 카카오 로그인

    //sdp
    implementation ("com.intuit.sdp:sdp-android:1.1.0")

    //lottie
    implementation ("com.airbnb.android:lottie:6.0.0")

    //오픈소스 라이선스
    implementation ("com.google.android.gms:play-services-oss-licenses:17.0.0")

    // parcelize
    runtimeOnly("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.8.0")

    // EncryptedSharedPreferences
    implementation ("androidx.security:security-crypto-ktx:1.1.0-alpha03")

    // gson
    implementation ("com.google.code.gson:gson:2.8.9")

}