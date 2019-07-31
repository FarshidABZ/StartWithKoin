package com.farshidabz.gettingstartkoin.utils.imageloader

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


/**
 * Created by farshid.abazari since 12/26/18
 *
 * Usage: image manager is a function to load images with Glide from remote and locale
 *
 * How to call: just call [loadImage]
 *
 * Useful parameter: placeHolder to show a image while image is loading,
 *   options to set options after loading images like show image as circle view or round image see [circleCropTransform]
 *   progress bar to show progress while loading image
 *   callback that returns loaded images as drawable and a boolean field for result of loading image
 *
 */

@SuppressLint("CheckResult")
fun loadImage(
    imageUrl: String?,
    imageViewToLoad: ImageView,
    placeHolderId: Int = 0,
    options: RequestOptions? = null,
    progressBar: ProgressBar? = null,
    forceOriginalSize: Boolean = false,
    diskCacheStrategy: DiskCacheStrategy = DiskCacheStrategy.AUTOMATIC,
    callback: ((Drawable?, Boolean) -> Unit)? = null
) {
    val glideRequest = getGlideRequest(imageViewToLoad.context, imageUrl)
    setPlaceHolder(glideRequest, placeHolderId)
    setOptions(glideRequest, options)
    setGlideListener(glideRequest, progressBar, callback)

    progressBar?.visibility = View.VISIBLE

    glideRequest.diskCacheStrategy(diskCacheStrategy)

    glideRequest.transition(DrawableTransitionOptions.withCrossFade())
    if (forceOriginalSize)
        glideRequest.override(Target.SIZE_ORIGINAL)
    glideRequest.into(imageViewToLoad)
}

@SuppressLint("CheckResult")
private fun setGlideListener(
    glideRequest: GlideRequest<Drawable>,
    progressBar: ProgressBar?,
    callback: ((Drawable?, Boolean) -> Unit)?
) {
    glideRequest.listener(object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            callback?.invoke(null, false)
            progressBar?.visibility = View.GONE
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            callback?.invoke(resource, true)
            progressBar?.visibility = View.GONE
            return false
        }
    })
}

private fun setOptions(glideRequest: GlideRequest<Drawable>, options: RequestOptions?) {
    options?.let {
        glideRequest.apply(options)
    }
}

@SuppressLint("CheckResult")
private fun setPlaceHolder(glideRequest: GlideRequest<Drawable>, placeHolderId: Int) {
    if (placeHolderId > 0) {
        glideRequest.placeholder(placeHolderId)
    }
}

private fun getGlideRequest(context: Context, imageUrl: String?) =
    GlideApp.with(context).load(imageUrl).centerCrop()

fun circleCropTransform() = RequestOptions.circleCropTransform()
fun roundCornerTransform(cornerRadius: Int) =
    RequestOptions().transforms(CenterCrop(), RoundedCorners(cornerRadius))
