import org.gradle.api.JavaVersion

object Configuration {
    const val applicationId = "com.jgeun.aftest"
    const val compileSdk = 31
    const val targetSdk = 31
    const val minSdk = 23
    const val versionCode = 1
    const val versionName = "1.0"
    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}