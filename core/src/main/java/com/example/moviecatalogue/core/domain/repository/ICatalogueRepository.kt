package com.example.moviecatalogue.core.domain.repository


import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.MovieEntityDomain
import com.example.moviecatalogue.core.domain.model.TvshowEntityDomain
import kotlinx.coroutines.flow.Flow


interface ICatalogueRepository {
    fun getAllMovies(): Flow<Resource<List<MovieEntityDomain>>>
    fun getDetailMovie(movieId: Int?): Flow<Resource<MovieEntityDomain>>
    fun getAllTvshows(): Flow<Resource<List<TvshowEntityDomain>>>
    fun getDetailTvshow(tvshowId: Int?): Flow<Resource<TvshowEntityDomain>>
    fun getFavoriteMovie(): Flow<List<MovieEntityDomain>>
    fun getFavoriteTvshow(): Flow<List<TvshowEntityDomain>>
    fun setFavoriteMovie(movie: MovieEntityDomain, state: Boolean)
    fun setFavoriteTvshow(tvshow: TvshowEntityDomain, state: Boolean)
}