package com.example.moviecataloge.presentation.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecataloge.data.source.local.entity.MovieEntity
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
class FavoriteMovieViewModelTest {
    private lateinit var viewModel: com.example.moviecatalogue.favorite.movie.FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel =
            com.example.moviecatalogue.favorite.movie.FavoriteMovieViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = pagedList
        Mockito.`when`(dummyMovies.size).thenReturn(4)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(catalogueRepository.getFavoriteMovie()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies().value
        assertNotNull(movieEntities)
        assertEquals(4, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}