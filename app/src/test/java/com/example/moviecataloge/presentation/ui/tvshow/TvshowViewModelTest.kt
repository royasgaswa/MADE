package com.example.moviecataloge.presentation.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecataloge.data.source.local.entity.TvshowEntity
import com.example.moviecataloge.data.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowViewModelTest {
    private lateinit var tvshowViewModel: com.example.moviecatalogue.tvshow.TvshowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvshowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        tvshowViewModel = com.example.moviecatalogue.tvshow.TvshowViewModel(catalogueRepository)
    }

    @Test
    fun getTvshow() {
        val dummyTvshows = Resource.success(pagedList)
        Mockito.`when`(dummyTvshows.data?.size).thenReturn(4)
        val tvshows = MutableLiveData<Resource<PagedList<TvshowEntity>>>()
        tvshows.value = dummyTvshows

        Mockito.`when`(catalogueRepository.getAllTvshows()).thenReturn(tvshows)
        val tvshowEntities = tvshowViewModel.getTvshow().value?.data
        assertNotNull(tvshowEntities)
        assertEquals(4, tvshowEntities?.size)

        tvshowViewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvshows)
    }
}