package com.example.moviecatalogue.tvshow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val tvShowModule= module {
    viewModel { TvShowViewModel(get()) }
}