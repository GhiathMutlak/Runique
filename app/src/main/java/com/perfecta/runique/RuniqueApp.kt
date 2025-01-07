package com.perfecta.runique

import android.app.Application
import com.perfecta.auth.data.di.authDataModule
import com.perfecta.auth.presentation.di.authPresentationModule
import com.perfecta.core.data.di.coreDataModule
import com.perfecta.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)

            modules(
                authDataModule,
                authPresentationModule,
                appModule,
                coreDataModule
            )

        }
    }
}