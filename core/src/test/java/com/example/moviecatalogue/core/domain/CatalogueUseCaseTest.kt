package com.example.moviecatalogue.core.domain

import com.example.moviecatalogue.core.domain.repository.ICatalogueRepository
import com.example.moviecatalogue.core.domain.usecase.CatalogueInteractor
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.example.moviecatalogue.core.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatalogueUseCaseTest {
    private lateinit var catalogueUseCase: CatalogueUseCase
    @Mock private lateinit var catalogueRepository: ICatalogueRepository


    suspend fun movies() = DataDummy.getAllDummyMovies()
    suspend fun tvShows()=DataDummy.getAllDummyTvShow()
    @Before
    fun setUp(){
        catalogueUseCase=CatalogueInteractor(catalogueRepository)

    }

    @Test
    fun getAllMovies(){
        runBlocking {
            `when`(catalogueRepository.getAllMovies()).thenReturn(movies())
            catalogueUseCase.getAllMovies()
            verify(catalogueRepository).getAllMovies()
            verifyNoMoreInteractions(catalogueRepository)
        }

    }
    @Test
    fun getAllTvShows(){
        runBlocking {
            `when`(catalogueRepository.getAllTvshows()).thenReturn(tvShows())
            catalogueUseCase.getAllTvshows()
            verify(catalogueRepository).getAllTvshows()
            verifyNoMoreInteractions(catalogueRepository)
        }
    }

}