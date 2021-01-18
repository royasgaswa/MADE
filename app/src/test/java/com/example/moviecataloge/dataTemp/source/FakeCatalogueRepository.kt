package com.example.moviecataloge.dataTemp.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecataloge.data.NetworkBoundResource
import com.example.moviecataloge.data.source.local.LocalDataSource
import com.example.moviecataloge.data.source.local.entity.MovieEntity
import com.example.moviecataloge.data.source.local.entity.TvshowEntity
import com.example.moviecataloge.data.source.remote.RemoteDataSource
import com.example.moviecataloge.data.source.remote.network.ApiResponse
import com.example.moviecataloge.data.source.remote.response.movie.MovieResponse
import com.example.moviecataloge.data.source.remote.response.tvshow.TvshowResponse
import com.example.moviecataloge.data.vo.Resource
import com.example.moviecataloge.utils.AppExecutors

class FakeCatalogueRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {
    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse?>?>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse?>?>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieResponse?>?) {
                val movieList = ArrayList<MovieEntity>()
                if (data != null) {
                    for (response in data) {
                        val movie =
                            MovieEntity(
                                response?.id,
                                response?.title,
                                response?.releaseDate,
                                response?.rate.toString(),
                                response?.overview,
                                String.format("https://image.tmdb.org/t/p/w185${response?.posterPath}"),
                                response?.backdropPath
                            )
                        movieList.add(movie)
                    }
                    localDataSource.insertMovies(movieList)
                }
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int?): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse?>?>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse?>?>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieResponse?>?) {
                val movieList = ArrayList<MovieEntity>()
                if (data != null) {
                    for (response in data) {
                        val movie = MovieEntity(
                            response?.id,
                            response?.title,
                            response?.releaseDate,
                            response?.rate,
                            response?.overview,
                            String.format("https://image.tmdb.org/t/p/w185${response?.posterPath}"),
                            String.format("https://image.tmdb.org/t/p/w185${response?.backdropPath}")
                        )
                        movieList.add(movie)
                    }
                    localDataSource.insertMovies(movieList)
                }
                Log.d("data3", movieList.size.toString())
            }
        }.asLiveData()
    }

    override fun getAllTvshows(): LiveData<Resource<PagedList<TvshowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowResponse?>?>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvshowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvshows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse?>?>> =
                remoteDataSource.getTvshow()

            override fun saveCallResult(data: List<TvshowResponse?>?) {
                val tvshowList = ArrayList<TvshowEntity>()
                if (data != null) {
                    for (response in data) {
                        val tvshow =
                            TvshowEntity(
                                response?.id,
                                response?.name,
                                response?.firstAirDate,
                                response?.rate.toString(),
                                response?.overview,
                                String.format("https://image.tmdb.org/t/p/w185${response?.posterPath}"),
                                String.format("https://image.tmdb.org/t/p/w185${response?.backdropPath}")
                            )
                        tvshowList.add(tvshow)
                    }
                    localDataSource.insertTvshow(tvshowList)
                }
            }
        }.asLiveData()
    }

    override fun getDetailTvshow(tvshowId: Int?): LiveData<Resource<TvshowEntity>> {
        return object : NetworkBoundResource<TvshowEntity, List<TvshowResponse?>?>(appExecutors) {
            override fun loadFromDB(): LiveData<TvshowEntity> =
                localDataSource.getTvshowById(tvshowId)

            override fun shouldFetch(data: TvshowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse?>?>> =
                remoteDataSource.getTvshow()

            override fun saveCallResult(data: List<TvshowResponse?>?) {
                val tvshowList = ArrayList<TvshowEntity>()
                if (data != null) {
                    for (response in data) {
                        if (response?.id == tvshowId) {
                            val tvshow = TvshowEntity(
                                response?.id,
                                response?.name,
                                response?.firstAirDate,
                                response?.rate.toString(),
                                response?.overview,
                                String.format("https://image.tmdb.org/t/p/w185${response?.posterPath}"),
                                String.format("https://image.tmdb.org/t/p/w185${response?.backdropPath}")
                            )
                            tvshowList.add(tvshow)
                        }
                    }
                    localDataSource.insertTvshow(tvshowList)
                }
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvshow(): LiveData<PagedList<TvshowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvshow(), config).build()
    }

    override fun setFavoriteTvshow(tvshow: TvshowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvshow(tvshow, state) }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        Log.d("data4", movie.toString())
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    }
}