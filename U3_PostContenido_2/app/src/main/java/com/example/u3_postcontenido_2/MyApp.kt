package com.example.u3_postcontenido_2

import android.app.Application
import com.example.u3_postcontenido_2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// MyApp.kt — Application con Koin (sin @HiltAndroidApp)
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}
