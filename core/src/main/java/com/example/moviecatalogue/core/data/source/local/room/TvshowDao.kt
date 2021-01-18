package com.example.moviecatalogue.core.data.source.local.room

import androidx.room.*
import com.example.moviecatalogue.core.data.source.local.entity.TvshowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvshowDao {
    @Query("SELECT * FROM tvshowentities")
    fun getTvshows(): Flow<List<TvshowEntity>>

    @Query("SELECT * FROM tvshowentities where favorite=1")
    fun getFavoriteTvshow(): Flow<List<TvshowEntity>>

    @Query("SELECT * FROM tvshowentities WHERE id = :id")
    fun getTvshowById(id: Int?): Flow<TvshowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvshow(tvshows: List<TvshowEntity>)

    @Update
    fun updateTvshow(tvshow: TvshowEntity)
}