package com.perfecta.runique

import android.app.Application
import com.perfecta.auth.data.di.authDataModule
import com.perfecta.auth.presentation.di.authPresentationModule
import com.perfecta.core.data.di.coreDataModule
import com.perfecta.core.database.di.databaseModule
import com.perfecta.run.location.di.locationModule
import com.perfecta.run.presentation.di.runPresentationModule
import com.perfecta.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)

            modules(
                appModule,
                authDataModule,
                authPresentationModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule
            )

        }
    }
}