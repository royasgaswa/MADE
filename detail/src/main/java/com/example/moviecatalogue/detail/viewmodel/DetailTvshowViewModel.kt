package com.example.moviecatalogue.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.TvshowEntityDomain
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.TvshowDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class DetailTvshowViewModel (val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private var tvshowId = MutableLiveData<Int>()
    private val _isLoading= MutableLiveData<Boolean>()
    private val _tvshow= MutableLiveData<com.example.moviecatalogue.base.presentation.model.TvshowEntityPresentation>()
    val isLoading:LiveData<Boolean> = _isLoading
    val tvshow:LiveData<com.example.moviecatalogue.base.presentation.model.TvshowEntityPresentation> = _tvshow

    fun setSelectedTvshow(tvshowId: Int?) {
        this.tvshowId.value = tvshowId
    }

    fun getDetailTvshow(){
        viewModelScope.launch {
            catalogueUseCase.getDetailTvshow(tvshowId.value)
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect { tvshow->
                    when (tvshow) {
                        is Resource.Loading -> _isLoading.postValue(true)
                        is Resource.Success -> if (tvshow.data != null) {
                            tvshow.data.let {
                                _isLoading.postValue(false)
                                val listData=ArrayList<TvshowEntityDomain>()
                                it?.let { it1 -> listData.add(it1) }
                                _tvshow.postValue(TvshowDataMapper.mapDomainToPresentation(listData)[0])
                            }
                        }
                        is Resource.Error -> {
                            _isLoading.postValue(true)
                        }
                    }
                }
        }
    }
    fun setFavorite() {
        val tvshowResource = tvshow.value
        if (tvshowResource != null) {
            val dataTvshow = TvshowDataMapper.mapPresentationToDomain(tvshowResource)
            val newstate = !dataTvshow.isFavorite
            catalogueUseCase.setFavoriteTvshow(dataTvshow, newstate)
        }
    }
}