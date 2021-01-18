package com.example.moviecatalogue.movie

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule= module {
    viewModel { MovieViewModel(get()) }
}