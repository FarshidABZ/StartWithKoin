package com.farshidabz.gettingstartkoin.di

import com.farshidabz.gettingstartkoin.view.main.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
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

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
}
