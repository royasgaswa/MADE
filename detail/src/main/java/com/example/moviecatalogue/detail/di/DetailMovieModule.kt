package com.example.moviecatalogue.detail.di

import com.example.moviecatalogue.detail.viewmodel.DetailMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule= module {
    viewModel { DetailMovieViewModel(get()) }
}