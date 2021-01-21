package com.example.moviecatalogue.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.base.presentation.model.TvShowEntityPresentation
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.TvshowDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class TvShowViewModel (private val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private val _isLoading= MutableLiveData<Boolean>()
    private val _tvShow = MutableLiveData<List<TvShowEntityPresentation>>()
    val isLoading: LiveData<Boolean> = _isLoading
    val tvShow:LiveData<List<TvShowEntityPresentation>> = _tvShow

    @ExperimentalCoroutinesApi
    fun getTvShow(){
        viewModelScope.launch {
            catalogueUseCase.getAllTvshows()
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect { tvshows->
                    when(tvshows){
                        is Resource.Loading->_isLoading.postValue(true)
                        is Resource.Success->{
                            _isLoading.postValue(false)
                            if (tvshows.data!=null){
                                _tvShow.postValue(tvshows.data?.let { TvshowDataMapper.mapDomainToPresentation(it) })
                            }else{
                                _tvShow.postValue(null)
                            }

                        }
                        is Resource.Error->_isLoading.postValue(false)
                    }
                }
        }
    }
}