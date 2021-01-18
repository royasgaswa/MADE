package com.example.moviecataloge.presentation.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecataloge.data.source.local.entity.MovieEntity
import com.example.moviecataloge.data.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var movieViewModel: com.example.moviecatalogue.movie.MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        movieViewModel = com.example.moviecatalogue.movie.MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(4)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = movieViewModel.getMovies().value?.data
        assertNotNull(movieEntities)
        assertEquals(4, movieEntities?.size)

        movieViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}