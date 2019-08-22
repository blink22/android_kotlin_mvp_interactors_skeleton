package com.blink22.mvpinteractorsskeleton

import android.app.Application
import com.blink22.mvpinteractorsskeleton.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinDI()
    }

    private fun initKoinDI() {
        startKoin {
            printLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}