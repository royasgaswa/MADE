package com.example.moviecatalogue.tvshow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val tvshowModule= module {
    viewModel { TvshowViewModel(get()) }
}