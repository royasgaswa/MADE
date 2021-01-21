package com.example.moviecatalogue.favorite.di

import com.example.moviecatalogue.favorite.movie.FavoriteMovieViewModel
import com.example.moviecatalogue.favorite.tvshow.FavoriteTvShowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val favoriteModule= module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvShowViewModel(get()) }
}