plugins {
    id(Plugins.Application.dependency)
    id(Plugins.Android.dependency)
    id(Plugins.Kapt.dependency)
    id(Plugins.Parcelable.dependency)
    id(Plugins.Ktlint.depencency) version (Plugins.Ktlint.version)
}

android {
    namespace = Config.appModulePackageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appModulePackageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    viewBinding.enable = true
    buildFeatures {
        viewBinding = true
    }
}

ktlint {
    android.set(true)
    ignoreFailures.set(false)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
    }
}

dependencies {
    // Basic
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.fragment)
    // Unit Testing
    testImplementation(Dependencies.UnitTesting.JUnit.core)
    testImplementation(Dependencies.UnitTesting.KotlinX.coroutines)
    // Ui Testing
    androidTestImplementation(Dependencies.AndroidTesting.JUnit.core)
    androidTestImplementation(Dependencies.AndroidTesting.JUnit.ui)
    androidTestImplementation(Dependencies.AndroidTesting.Espresso.core)
    androidTestImplementation(Dependencies.AndroidTesting.AndroidX.core)
    androidTestImplementation(Dependencies.AndroidTesting.Barista.core)
    // Navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)
    // Room
    implementation(Dependencies.Room.core)
    kapt(Dependencies.Room.compiler)
}
