package com.example.moviecataloge.presentation.ui.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecataloge.data.source.local.entity.TvshowEntity
import com.example.moviecataloge.data.vo.Resource
import com.example.moviecataloge.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvshowViewModelTest {
    private lateinit var detailTvshowViewModel: com.example.moviecatalogue.detail.viewmodel.DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTv()[0]
    private val tvshowId = dummyTvshow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<TvshowEntity>>

    @Before
    fun setUp() {
        detailTvshowViewModel =
            com.example.moviecatalogue.detail.viewmodel.DetailTvshowViewModel(catalogueRepository)
        detailTvshowViewModel.setSelectedTvshow(tvshowId)
    }

    @Test
    fun getTvshow() {
        val dummyDetailTvshow =
            Resource.success(DataDummy.generateDummyFavoriteTvshow(dummyTvshow, true))
        val tvshow = MutableLiveData<Resource<TvshowEntity>>()
        tvshow.value = dummyDetailTvshow

        `when`(catalogueRepository.getDetailTvshow(tvshowId)).thenReturn(tvshow)

        /*val tvshowEntity = detailTvshowViewModel.getTvshow().value
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.id, tvshowEntity?.id)
        assertEquals(dummyTvshow.title, tvshowEntity?.title)
        assertEquals(dummyTvshow.date, tvshowEntity?.date)
        assertEquals(dummyTvshow.rate, tvshowEntity?.rate)
        assertEquals(dummyTvshow.overview, tvshowEntity?.overview)
        assertEquals(dummyTvshow.path, tvshowEntity?.path)
        assertEquals(dummyTvshow.backdropPath, tvshowEntity?.backdropPath)*/

        detailTvshowViewModel.getTvshow.observeForever(observer)
        verify(observer).onChanged(dummyDetailTvshow)
    }
}