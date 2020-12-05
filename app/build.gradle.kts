plugins {
    id(PluginsID.APPLICATION)
    id(PluginsID.KOTLIN_ANDROID)
}
setupApp()
dependencies {
    implementation(project(":base"))

}