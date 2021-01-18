package com.example.moviecatalogue.favorite.di

import com.example.moviecatalogue.favorite.movie.FavoriteMovieViewModel
import com.example.moviecatalogue.favorite.tvshow.FavoriteTvshowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule= module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvshowViewModel(get()) }
}