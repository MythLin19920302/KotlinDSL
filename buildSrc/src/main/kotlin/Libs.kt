object Libs {
    const val junit = "junit:junit:_"
    const val testRunner = "androidx.test:runner:_"
    const val testEspresso = "androidx.test.espresso:espresso-core:_"
    const val rxJava = "io.reactivex.rxjava3:rxjava:_"
    const val koinAndroid = "org.koin:koin-android:_"
    const val koinAndroidxScope = "org.koin:koin-androidx-scope:_"
    const val koinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:_"
    const val koinAndroidxEx = "org.koin:koin-androidx-ext:_"
}

fun String.fullLib(replacement: String): String = this.replaceAfterLast('_', replacement)
object FullLibs {}
object Versions {}