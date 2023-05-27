plugins {
    id(Plugins.Application.dependency)
    id(Plugins.Android.dependency)
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {
    //Basic
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.material)
    //Unit Testing
    testImplementation(Dependencies.Testing.JUnit.core)
    testImplementation(Dependencies.Testing.KotlinX.coroutines)
    //Ui Testing
    androidTestImplementation(Dependencies.Testing.JUnit.ui)
    androidTestImplementation(Dependencies.Testing.Espresso.core)
    //Modules
    implementation(project(Modules.coreModule))
    implementation(project(Modules.coreDatasourceModule))
    implementation(project(Modules.featNotesModule))
}