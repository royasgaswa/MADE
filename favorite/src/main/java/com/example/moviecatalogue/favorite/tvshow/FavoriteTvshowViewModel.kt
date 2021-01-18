package com.example.moviecatalogue.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.base.presentation.model.TvshowEntityPresentation
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.TvshowDataMapper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class FavoriteTvshowViewModel (val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private val _isLoading= MutableLiveData<Boolean>()
    private val _tvshow = MutableLiveData<List<TvshowEntityPresentation>>()
    val isLoading: LiveData<Boolean> = _isLoading
    val tvshows : LiveData<List<TvshowEntityPresentation>> = _tvshow
    fun getFavoriteTvshow(){
        viewModelScope.launch {
            catalogueUseCase.getFavoriteTvshow()
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect {
                    _isLoading.postValue(false)
                    _tvshow.postValue(TvshowDataMapper.mapDomainToPresentation(it))
                }
        }
    }
}