package com.example.moviecatalogue.tvshow

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tvshowModule= module {
    viewModel { TvshowViewModel(get()) }
}