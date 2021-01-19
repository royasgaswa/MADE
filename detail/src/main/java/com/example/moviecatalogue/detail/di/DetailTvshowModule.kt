package com.example.moviecatalogue.detail.di

import com.example.moviecatalogue.detail.viewmodel.DetailTvshowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val tvshowModule= module {
    viewModel { DetailTvshowViewModel(get()) }
}