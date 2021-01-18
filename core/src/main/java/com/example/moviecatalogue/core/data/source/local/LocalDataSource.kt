package com.example.moviecatalogue.core.data.source.local

import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.core.data.source.local.entity.TvshowEntity
import com.example.moviecatalogue.core.data.source.local.room.MovieDao
import com.example.moviecatalogue.core.data.source.local.room.TvshowDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val mMovieDao: MovieDao,
    private val mTvshowDao: TvshowDao
) {
    fun getAllMovies(): Flow<List<MovieEntity>> = mMovieDao.getMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = mMovieDao.getFavoriteMovie()

    fun getMovieById(id: Int?): Flow<MovieEntity> {
        return mMovieDao.getMovieById(id)
    }

    suspend fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun getAllTvshows(): Flow<List<TvshowEntity>> = mTvshowDao.getTvshows()

    fun getFavoriteTvshow(): Flow<List<TvshowEntity>> = mTvshowDao.getFavoriteTvshow()

    fun getTvshowById(id: Int?): Flow<TvshowEntity> =
        mTvshowDao.getTvshowById(id)

    suspend fun insertTvshow(tvshows: List<TvshowEntity>) = mTvshowDao.insertTvshow(tvshows)

    fun setFavoriteTvshow(tvshow: TvshowEntity, newState: Boolean) {
        tvshow.favorite = newState
        mTvshowDao.updateTvshow(tvshow)
    }
}