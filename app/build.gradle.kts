plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.searchfilms"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.searchfilms"
        minSdk = 29
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.tracing.perfetto.handshake)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    // Retrofit core
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter (для автоматической десериализации JSON в MoviesSearchResponse)
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp logging (для дебаггинга ответов API)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
    // Kotlin extensions (для использования suspend fun в будущем)
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")  // Уже имеется
    // KAPT для аннотаций
    kapt ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")  // Актуальная версия на 2023–2024

    // Опционально: интеграция с OkHttp для лучшей загрузки (если используете Retrofit)
    implementation("com.github.bumptech.glide:recyclerview-integration:4.16.0")  // Для RecyclerView, если нужн

    val moxyVersion = "2.2.2"
    implementation ("com.github.moxy-community:moxy:$moxyVersion")
    implementation ("com.github.moxy-community:moxy-android:$moxyVersion")
    kapt ("com.github.moxy-community:moxy-compiler:$moxyVersion")

    kapt ("com.squareup.retrofit2:retrofit:2.9.0")

}
