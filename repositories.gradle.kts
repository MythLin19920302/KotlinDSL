rootProject.extra.apply {
  set("androidPlugin", "com.android.tools.build:gradle:4.1.1")
  set("firebaseCrash", "com.google.firebase:firebase-crashlytics-gradle:2.4.1")
  set("kotlinVersion", "1.4.10")
}

repositories {
  google()
  jcenter()
}

