package com.example.moviecatalogue.core.domain.usecase

import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.MovieEntityDomain
import com.example.moviecatalogue.core.domain.model.TvShowEntityDomain
import kotlinx.coroutines.flow.Flow

interface CatalogueUseCase {
    fun getAllMovies(): Flow<Resource<List<MovieEntityDomain>>>
    fun getDetailMovie(movieId: Int?): Flow<Resource<MovieEntityDomain>>
    fun getAllTvshows(): Flow<Resource<List<TvShowEntityDomain>>>
    fun getDetailTvshow(tvshowId: Int?): Flow<Resource<TvShowEntityDomain>>
    fun getFavoriteMovie(): Flow<List<MovieEntityDomain>>
    fun getFavoriteTvshow(): Flow<List<TvShowEntityDomain>>
    fun setFavoriteMovie(movie: MovieEntityDomain, state: Boolean)
    fun setFavoriteTvshow(tvShow: TvShowEntityDomain, state: Boolean)
}