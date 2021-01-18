package com.example.moviecatalogue.core.data.source.local.room

import androidx.room.*
import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getMovieById(id: Int?): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)
}