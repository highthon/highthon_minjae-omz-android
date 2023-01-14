package com.minjae.highthon.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.orbitmvi.orbit.viewmodel.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class OmzApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
