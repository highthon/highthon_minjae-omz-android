plugins {
    id(BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id(BuildPlugins.DAGGER_HILT_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KT_LINT) version Versions.KT_LINT
}

android {
    namespace = ProjectProperties.APPLICATION_ID
    compileSdk = ProjectProperties.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = ProjectProperties.APPLICATION_ID
        minSdk = ProjectProperties.MIN_SDK_VERSION
        targetSdk = ProjectProperties.TARGET_SDK_VERSION
        versionCode = ProjectProperties.VERSION_CODE
        versionName = ProjectProperties.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
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
        sourceCompatibility = ProjectProperties.JAVA_VERSION
        targetCompatibility = ProjectProperties.JAVA_VERSION
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
        kotlinCompilerVersion = ProjectProperties.KOTLIN_VERSION
    }

    kotlinOptions {
        jvmTarget = ProjectProperties.JAVA_VERSION.toString()
    }
}

dependencies {
    implementation(Dependencies.Logger.TIMBER)

    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    implementation(Dependencies.Kotlin.COROUTINES_CORE)
    implementation(Dependencies.Kotlin.COROUTINES_ANDROID)
    implementation(Dependencies.Kotlin.KOTLIN_STDLIB)

    implementation(Dependencies.Moshi.MOSHI)
    kapt(Dependencies.Moshi.MOSHI_COMPILER)

    implementation(Dependencies.Compose.COMPOSE_ACTIVITY)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.Compose.COMPOSE_PREVIEW)
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_NAV)
    implementation(Dependencies.Compose.COMPOSE_ANI_NAV)
    implementation(Dependencies.Compose.COMPOSE_UI_TOOL)
    implementation(Dependencies.Compose.COMPOSE_HILT_NAV)

    implementation(Dependencies.Mvi.ORBIT_VIEWMODEL)
    implementation(Dependencies.Mvi.ORBIT_CORE)
    implementation("com.google.accompanist:accompanist-flowlayout:0.25.0")

    androidTestImplementation(Dependencies.Compose.COMPOSE_TEST)
    debugImplementation(Dependencies.Compose.COMPOSE_UI_TOOL)

    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.RETROFIT_CONVERTER_GSON)

    implementation(Dependencies.OkHttp.OKHTTP)
    implementation(Dependencies.OkHttp.OKHTTP_LOGGING_INTERCEPTOR)

    implementation(Dependencies.Ui.SPLASH_SCREEN_API)
    implementation(Dependencies.Ui.CORE_KTX)
    implementation(Dependencies.Ui.APP_COMPAT)
    implementation(Dependencies.Ui.MATERIAL)
    implementation(Dependencies.Ui.CONSTRAINT_LAYOUT)

    implementation(Dependencies.Room.ROOM_RUNTIME)
    kapt(Dependencies.Room.ROOM_COMPILER)

    testImplementation(Dependencies.UnitTest.JUNIT)
    testImplementation(Dependencies.UnitTest.MOCKITO)
    testImplementation(Dependencies.UnitTest.MOCKITO_KOTLIN)
    testImplementation(Dependencies.UnitTest.MOCKITO_INLINE)

    implementation("team.duckie.quack:quack-ui-components:1.4.5")
}
