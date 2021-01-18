package com.example.moviecataloge.dataTemp.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecataloge.data.source.local.LocalDataSource
import com.example.moviecataloge.data.source.local.entity.MovieEntity
import com.example.moviecataloge.data.source.local.entity.TvshowEntity
import com.example.moviecataloge.data.source.remote.RemoteDataSource
import com.example.moviecataloge.data.vo.Resource
import com.example.moviecataloge.presentation.ui.utils.PagedListUtil
import com.example.moviecataloge.utils.AppExecutors
import com.example.moviecataloge.utils.DataDummy
import com.example.moviecataloge.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id
    private val tvshowResponse = DataDummy.generateRemoteDummyTvshow()
    private val tvshowId = tvshowResponse[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
    }

    @Test
    fun getDetailMovie() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovieById(movieId)).thenReturn(dummyEntity)
        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.title)
        assertEquals(movieResponse[0].title, movieEntities.data?.title)
    }

    @Test
    fun getAllTvshows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getAllTvshows()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllTvshows()
        val tvshowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getAllTvshows()
        assertNotNull(tvshowEntities.data)
    }

    @Test
    fun getDetailTvshow() {
        val dummyEntity = MutableLiveData<TvshowEntity>()
        dummyEntity.value = DataDummy.generateDummyTv()[0]
        `when`(local.getTvshowById(tvshowId)).thenReturn(dummyEntity)
        val tvshowEntities =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailTvshow(tvshowId))
        verify(local).getTvshowById(tvshowId)
        assertNotNull(tvshowEntities.data)
        assertNotNull(tvshowEntities.data?.title)
        assertEquals(tvshowResponse[0].name, tvshowEntities.data?.title)
    }
}