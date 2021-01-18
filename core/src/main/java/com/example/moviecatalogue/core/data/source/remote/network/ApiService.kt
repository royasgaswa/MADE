package com.example.moviecatalogue.core.data.source.remote.network

import com.example.moviecatalogue.core.data.source.remote.response.movie.ResponseMovies
import com.example.moviecatalogue.core.data.source.remote.response.tvshow.ResponseTvshow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMovies(@Query("api_key") key: String): ResponseMovies

    @GET("tv/popular?&language=en-US&page=1")
    suspend fun getTvshow(@Query("api_key") key: String): ResponseTvshow
}