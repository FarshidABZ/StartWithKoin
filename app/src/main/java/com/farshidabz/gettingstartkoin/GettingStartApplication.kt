package com.farshidabz.gettingstartkoin

import android.app.Application
import com.farshidabz.gettingstartkoin.di.networkModule
import com.farshidabz.gettingstartkoin.di.repositoryModule
import com.farshidabz.gettingstartkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * Created by farshid.abazari since 2019-07-31
 *
 * Usage:
 *
 * How to call:
 *
 * Useful parameter:
 *
 */

class GettingStartApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GettingStartApplication)
            modules(listOf(repositoryModule, networkModule, viewModelModule))
        }
    }
}