package com.example.moviecatalogue.detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.MovieEntityDomain
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.MovieDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class DetailMovieViewModel (val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private var movieId = MutableLiveData<Int>()
    private val _isLoading= MutableLiveData<Boolean>()
    private val _movie= MutableLiveData<com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation>()
    val isLoading: LiveData<Boolean> = _isLoading
    val movie: LiveData<com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation> = _movie

    fun setSelectedMovie(movieId: Int?) {
        this.movieId.value = movieId
    }
    fun getDetailMovie(){
        viewModelScope.launch {
            catalogueUseCase.getDetailMovie(movieId.value)
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect {movies->
                    when(movies){
                        is Resource.Loading->_isLoading.postValue(true)
                        is Resource.Success->{
                            _isLoading.postValue(false)
                            _movie.postValue(movies.data?.let {
                                val listData =ArrayList<MovieEntityDomain>()
                                listData.add(it)
                                MovieDataMapper.mapDomainToPresentation(listData)[0]
                            })
                        }
                        is Resource.Error->{
                            _isLoading.postValue(true)
                        }
                    }
                }
        }
    }

    fun setFavorite() {
        val movieResource = movie.value
        Log.d("data2", movieResource.toString())
        if (movieResource != null) {
            val dataMovie = MovieDataMapper.mapPresentationToDomain(movieResource)
            val newstate = !dataMovie.isFavorite
            catalogueUseCase.setFavoriteMovie(dataMovie, newstate)
        }
    }
}