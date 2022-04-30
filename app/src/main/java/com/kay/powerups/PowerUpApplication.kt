package com.kay.powerups

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class PowerUpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) Level.ERROR else {
                    Level.NONE
                }
            )
            androidContext(this@PowerUpApplication)
            modules(appModule)
        }
    }
}
