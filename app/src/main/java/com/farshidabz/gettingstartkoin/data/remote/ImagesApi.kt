package com.farshidabz.gettingstartkoin.data.remote

import com.farshidabz.gettingstartkoin.data.model.ImagesResponseModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by farshid.abazari since 12/27/18
 *
 * Usage: a interface to define end points
 *
 * How to call: just add in appInjector and repositoryImpl that you wanna use
 *
 */
interface ImagesApi {
    @GET("images/search?query=l")
    fun getImages() : Call<ImagesResponseModel>
}