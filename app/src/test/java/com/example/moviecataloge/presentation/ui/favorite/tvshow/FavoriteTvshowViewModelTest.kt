package com.example.moviecataloge.presentation.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecataloge.data.source.local.entity.TvshowEntity
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
class FavoriteTvshowViewModelTest {
    private lateinit var viewModel: com.example.moviecatalogue.favorite.tvshow.FavoriteTvshowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvshowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel =
            com.example.moviecatalogue.favorite.tvshow.FavoriteTvshowViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteTvshow() {
        val dummyTvshow = pagedList
        Mockito.`when`(dummyTvshow.size).thenReturn(4)
        val tvshow = MutableLiveData<PagedList<TvshowEntity>>()
        tvshow.value = dummyTvshow

        Mockito.`when`(catalogueRepository.getFavoriteTvshow()).thenReturn(tvshow)
        val tvshowEntities = viewModel.getFavoriteTvshow().value
        assertNotNull(tvshowEntities)
        assertEquals(4, tvshowEntities?.size)

        viewModel.getFavoriteTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}