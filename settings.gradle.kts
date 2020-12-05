import de.fayard.refreshVersions.bootstrapRefreshVersions
include(":app",":base")
buildscript {
    repositories { gradlePluginPortal() }
    dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
}
bootstrapRefreshVersions()
rootProject.name="KotlinDSL"

