object Dependencies {

    val kotlin = Kotlin
    val lifecycle = LifeCycle
    val hilt = Hilt
    val retrofit = Retrofit()
    val okHttp = OkHttp()

    object Kotlin {
        val coroutine by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }
    }

    object LifeCycle {
        val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
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

}