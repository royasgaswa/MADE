package com.example.moviecatalogue.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.MovieDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MovieViewModel (private val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private val _isLoading=MutableLiveData<Boolean>()
    private val _movie=MutableLiveData<List<MovieEntityPresentation>>()
    val isLoading:LiveData<Boolean> = _isLoading
    val movie:LiveData<List<MovieEntityPresentation>> = _movie
    @ExperimentalCoroutinesApi
    fun getMovies(){
        viewModelScope.launch {
            catalogueUseCase.getAllMovies()
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect {movies->
                    when(movies){
                        is Resource.Loading->_isLoading.postValue(true)
                        is Resource.Success->{
                            _isLoading.postValue(false)
                            if (movies.data!=null){
                                _movie.postValue(movies.data?.let { MovieDataMapper.mapDomainToPresentation(it) })
                            }else{
                                _movie.postValue(null)
                            }
                        }
                        is Resource.Error->{
                            _isLoading.postValue(true)
                        }
                    }
                }
        }
    }
}