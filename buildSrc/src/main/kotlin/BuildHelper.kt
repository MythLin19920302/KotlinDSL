import com.android.build.OutputFile
import com.android.build.gradle.AbstractAppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.api.ApkVariantOutputImpl
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware

import org.gradle.kotlin.dsl.configure

import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByName
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import java.io.File
import kotlin.jvm.internal.Intrinsics

private val Project.android get() = extensions.getByName<BaseExtension>("android")

fun Project.setupCommon() {
    plugins.apply(PluginsID.KOTLIN_ANDROID)
    plugins.apply(PluginsID.KOTLIN_ANDROID_EXTENSIONS)
    android.apply {
        buildToolsVersion(Android.buildToolsVersion)
        compileSdkVersion(Android.compileSdkVersion)
        defaultConfig {
            minSdkVersion(Android.minSdkVersion)
            targetSdkVersion(Android.targetSdkVersion)
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        val javaVersion = JavaVersion.VERSION_1_8
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
        (this as ExtensionAware).extensions.getByName<KotlinJvmOptions>("kotlinOptions").jvmTarget =
            javaVersion.toString()
    }
    dependencies {
        add("testImplementation", Libs.junit)
        add("androidTestImplementation", Libs.testRunner)
        add("androidTestImplementation", Libs.testEspresso)
    }

}


fun Project.setupApp() {
    plugins.apply(PluginsID.FIREBASE_CRASHLYTICS)
    setupCommon()
    android.apply {
        defaultConfig {
            versionCode = Android.versionCode
            versionName = Android.versionName
            applicationId = Android.applicationId
            multiDexEnabled = true
        }
        signingConfigs {
            register("release") {
                storeFile = Signing.storeFile(rootProject)
                storePassword = Signing.storePassword
                keyAlias = Signing.keyAlias
                keyPassword = Signing.keyPassword
            }
        }
        buildTypes {
            getByName("debug") {
                isPseudoLocalesEnabled = true
                (this as ExtensionAware).configure<CrashlyticsExtension> {
                    mappingFileUploadEnabled = false
                    nativeSymbolUploadEnabled = false
                }
            }
            getByName("release") {
                isShrinkResources = true
                isMinifyEnabled = true
                signingConfig = signingConfigs.getByName("release")
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }
//        packagingOptions {
//            exclude("**/*.kotlin_*")
//        }
        splits.abi {
            this.isEnable = true
            reset()
            include("armeabi-v7a", "arm64-v8a")
            this.isUniversalApk = false
        }
        (this as AbstractAppExtension).applicationVariants.all {
            val variant = this
            val channel = project.properties["custom_channel"]?.toString() ?: ""
            for (out in outputs) {
                val fileName = StringBuilder("HuangLin-")
                fileName.append("${(out as ApkVariantOutputImpl).getFilter(OutputFile.ABI)}-${channel}-")
                fileName.append("${(variant.versionName)}-")
                fileName.append("${variant.buildType.name}.apk")
                out.outputFileName = fileName.toString()
            }
        }
        sourceSets {
            getByName("main") {
                manifest.srcFile("src/main/AndroidManifest.xml")
//                java.srcDirs("src/main/java")
//                jniLibs.srcDirs("libs")
//                assets.srcDirs("src")
                res.srcDirs("src/main/res")
            }
        }
    }
}
