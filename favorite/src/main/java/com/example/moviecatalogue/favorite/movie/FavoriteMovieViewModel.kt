package com.example.moviecatalogue.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.MovieDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class FavoriteMovieViewModel (val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private val _isLoading= MutableLiveData<Boolean>()
    private val _movie= MutableLiveData<List<MovieEntityPresentation>>()
    val isLoading: LiveData<Boolean> = _isLoading
    val movie: LiveData<List<MovieEntityPresentation>> = _movie
    fun getFavoriteMovies(){
        viewModelScope.launch {
            catalogueUseCase.getFavoriteMovie()
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect {movies->
                    _movie.postValue(movies.let { MovieDataMapper.mapDomainToPresentation(it) })
                }
        }
    }
}