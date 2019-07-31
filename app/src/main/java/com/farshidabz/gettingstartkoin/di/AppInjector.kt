package com.farshidabz.gettingstartkoin.di

import com.farshidabz.gettingstartkoin.data.remote.ImagesApi
import org.koin.dsl.module
import retrofit2.Retrofit


/**
 * Created by farshid.abazari since 12/27/18
 *
 * Usage: this methods handle DI
 *
 * How to call: just startActivityForResult koin in application class
 *
 */

private val retrofit: Retrofit = createNetworkClient()


private val IMAGES_API: ImagesApi = retrofit.create(ImagesApi::class.java)

val networkModule = module {
    single { IMAGES_API }
}