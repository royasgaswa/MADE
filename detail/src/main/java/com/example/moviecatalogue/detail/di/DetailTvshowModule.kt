package com.example.moviecatalogue.detail.di

import com.example.moviecatalogue.detail.viewmodel.DetailTvShowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val tvShowModule= module {
    viewModel { DetailTvShowViewModel(get()) }
}