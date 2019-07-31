package com.farshidabz.gettingstartkoin.di

import com.farshidabz.gettingstartkoin.data.repository.ImagesRepo
import com.farshidabz.gettingstartkoin.utils.LocationHandler
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**
 * Created by farshid.abazari since 4/9/19
 *
 * Usage:
 *
 * How to call:
 *
 * Useful parameter:
 *
 */

val repositoryModule = module {
    single { ImagesRepo(androidContext(), imagesApi = get()) }

    single { LocationHandler() }
}