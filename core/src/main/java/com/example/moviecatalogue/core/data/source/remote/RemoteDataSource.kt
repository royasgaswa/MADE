package com.example.moviecatalogue.core.data.source.remote

import android.util.Log
import com.example.moviecatalogue.core.BuildConfig
import com.example.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.example.moviecatalogue.core.data.source.remote.network.ApiService
import com.example.moviecatalogue.core.data.source.remote.response.movie.MovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.tvshow.TvShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getMovies(): Flow<ApiResponse<List<MovieResponse?>>> {
        return flow {
            try {
                val response=apiService.getMovies(BuildConfig.API_KEY)
                val dataArray=response.results
                if (dataArray != null) {
                    emit(ApiResponse.Success(response.results))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTvshow(): Flow<ApiResponse<List<TvShowResponse?>>> {
        return flow {
            try {
                val response=apiService.getTvshow(BuildConfig.API_KEY)
                val dataArray=response.results
                if (dataArray!=null){
                    emit(ApiResponse.Success(response.results))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}