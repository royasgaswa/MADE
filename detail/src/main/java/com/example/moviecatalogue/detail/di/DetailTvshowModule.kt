package com.example.moviecatalogue.detail.di

import com.example.moviecatalogue.detail.viewmodel.DetailTvshowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tvshowModule= module {
    viewModel { DetailTvshowViewModel(get()) }
}