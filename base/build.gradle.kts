plugins {
    id(PluginsID.LIBRARY)
    id(PluginsID.KOTLIN_ANDROID)
    id(PluginsID.KOTLIN_KAPT)
//    id(PluginsID.DAGGER_PLUGIN)
}
setupCommon()

dependencies {
    api(AndroidX.appCompat)
    api(AndroidX.constraintLayout)
    api(AndroidX.fragmentKtx)
    api(AndroidX.core.ktx)
    api(AndroidX.multidex)
    api(AndroidX.recyclerView)
    api(AndroidX.lifecycle.viewModelKtx)
    api(AndroidX.lifecycle.liveDataKtx)
    api(AndroidX.lifecycle.liveDataCoreKtx)
    api(Google.android.material)
    api(Kotlin.stdlib.jdk8)
    api(Kotlin.stdlib.common)
    api(KotlinX.coroutines.core)
    api(KotlinX.coroutines.android)
    api(Square.okHttp3.okHttp)
    api(Square.okHttp3.loggingInterceptor)
    api(Square.retrofit2.retrofit)
}