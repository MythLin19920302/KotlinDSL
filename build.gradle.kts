buildscript {
    apply(from = "repositories.gradle.kts")
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(rootProject.extra.get("androidPlugin").toString())
        classpath(rootProject.extra.get("firebaseCrash").toString())
        classpath(
            kotlin(
                "gradle-plugin",
                rootProject.extra.get("kotlinVersion").toString()
            ).toString()
        )
        classpath(Google.dagger.hilt.android.gradlePlugin)
    }
}

allprojects {
    apply(from = "${rootProject.projectDir}/repositories.gradle.kts")
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}