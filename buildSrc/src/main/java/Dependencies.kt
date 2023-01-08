object Dependencies {

    val androidx = AndroidX
    val kotlin = Kotlin
    val lifecycle = LifeCycle
    val navigation = Navigation
    val hilt = Hilt
    val retrofit = Retrofit()
    val okHttp = OkHttp()
    val glide = Glide()
    val gson = Gson()
    val test = Test

    object AndroidX {
        val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompact}" }
        val material by lazy { "com.google.android.material:material:${Versions.material}" }
        val constraint by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraint}" }
    }

    object Kotlin {
        val coroutine by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }
    }

    object LifeCycle {
        val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    }

    object Navigation {
        val fragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
        val ui by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
    }

    class Retrofit(
        private val name: String = "com.squareup.retrofit2:retrofit:${Versions.retrofit}",
    ) : CharSequence by name {
        val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }

        override fun toString() = name
    }

    class OkHttp(
        private val name: String = "com.squareup.okhttp3:okhttp:${Versions.okHttp}",
    ) : CharSequence by name {
        val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}" }

        override fun toString() = name
    }

    class Glide(
        private val name: String = "com.github.bumptech.glide:glide:${Versions.glide}",
    ) : CharSequence by name {
        val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

        override fun toString() = name
    }

    class Gson(
        private val name: String = "com.google.code.gson:gson:2.10.1"
    ) : CharSequence by name {

        override fun toString(): String = name
    }


    object Test {
        val jUnit by lazy { "junit:junit:4.13.2" }
        val jUnitExt by lazy { "androidx.test.ext:junit:1.1.4" }
        val expresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    }

}