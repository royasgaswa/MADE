package com.example.moviecatalogue.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.base.presentation.model.TvShowEntityPresentation
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.TvShowEntityDomain
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.TvshowDataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class DetailTvShowViewModel (val catalogueUseCase: CatalogueUseCase) :
    ViewModel() {
    private var tvShowId = MutableLiveData<Int>()
    private val _isLoading= MutableLiveData<Boolean>()
    private val _tvShow= MutableLiveData<TvShowEntityPresentation>()
    val isLoading:LiveData<Boolean> = _isLoading
    val tvShow:LiveData<TvShowEntityPresentation> = _tvShow

    fun setSelectedTvshow(tvshowId: Int?) {
        this.tvShowId.value = tvshowId
    }

    fun getDetailTvshow(){
        viewModelScope.launch {
            catalogueUseCase.getDetailTvshow(tvShowId.value)
                .onStart { _isLoading.postValue(true) }
                .onCompletion { _isLoading.postValue(false) }
                .collect { tvshow->
                    when (tvshow) {
                        is Resource.Loading -> _isLoading.postValue(true)
                        is Resource.Success -> if (tvshow.data != null) {
                            tvshow.data.let {
                                _isLoading.postValue(false)
                                val listData=ArrayList<TvShowEntityDomain>()
                                it?.let { it1 -> listData.add(it1) }
                                _tvShow.postValue(TvshowDataMapper.mapDomainToPresentation(listData)[0])
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
        val tvshowResource = tvShow.value
        if (tvshowResource != null) {
            val dataTvshow = TvshowDataMapper.mapPresentationToDomain(tvshowResource)
            val newstate = !dataTvshow.isFavorite
            catalogueUseCase.setFavoriteTvshow(dataTvshow, newstate)
        }
    }
}