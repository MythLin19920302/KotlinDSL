import org.gradle.api.Project
import java.io.File

object Android {
    const val applicationId = "com.dywx.larkplayer"
    const val compileSdkVersion = 30
    const val minSdkVersion = 17
    const val targetSdkVersion = 30
    const val buildToolsVersion = "30.0.2"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Signing {
    fun storeFile(rootProject: Project): File = File("${rootProject.projectDir}/key/dywx.jks")
    const val storePassword = "LarkPlayer"
    const val keyAlias = "LarkPlayer"
    const val keyPassword = "LarkPlayer"
}


object PluginsID {
    const val APPLICATION = "com.android.application"
    const val LIBRARY = "com.android.library"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase.crashlytics"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val DAGGER_PLUGIN = "dagger.hilt.android.plugin"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
}

