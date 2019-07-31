package com.farshidabz.gettingstartkoin.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farshidabz.gettingstartkoin.data.model.ImagesResponseModel
import com.farshidabz.gettingstartkoin.data.repository.ImagesRepo


/**
 * Created by farshid.abazari since 2019-07-30
 *
 * Usage:
 *
 * How to call:
 *
 * Useful parameter:
 *
 */

class MainActivityViewModel(private val imagesRepo: ImagesRepo) : ViewModel() {
    var imageResponseLiveData = MutableLiveData<ImagesResponseModel>()

    fun getImages() {
        imagesRepo.getImages(imageResponseLiveData)
    }
}