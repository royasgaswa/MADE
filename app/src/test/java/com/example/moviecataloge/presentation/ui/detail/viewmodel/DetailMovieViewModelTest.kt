package com.example.moviecataloge.presentation.ui.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecataloge.data.source.local.entity.MovieEntity
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
class DetailMovieViewModelTest {
    private lateinit var detailMovieViewModel: com.example.moviecatalogue.detail.viewmodel.DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: _root_ide_package_.com.example.moviecatalogue.core.data.CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        detailMovieViewModel =
            com.example.moviecatalogue.detail.viewmodel.DetailMovieViewModel(catalogueRepository)
        detailMovieViewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val dummyDetailMovie =
            Resource.success(DataDummy.generateDummyFavoriteMovie(dummyMovie, true))
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movie)
        /*val movieEntity = detailMovieViewModel.getMovie().value*/
        /*assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity?.id)
        assertEquals(dummyMovie.title, movieEntity?.title)
        assertEquals(dummyMovie.date, movieEntity?.date)
        assertEquals(dummyMovie.rate, movieEntity?.rate)
        assertEquals(dummyMovie.overview, movieEntity?.overview)
        assertEquals(dummyMovie.path, movieEntity?.path)
        assertEquals(dummyMovie.backdropPath, movieEntity?.backdropPath)*/

        detailMovieViewModel.getMovie.observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

}