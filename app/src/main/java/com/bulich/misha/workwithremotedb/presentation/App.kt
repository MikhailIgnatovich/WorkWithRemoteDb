package com.bulich.misha.workwithremotedb.presentation

import android.app.Application
import com.bulich.misha.workwithremotedb.presentation.di.moduleFilms
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(moduleFilms)
        }
    }
}