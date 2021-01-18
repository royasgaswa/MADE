package com.example.moviecatalogue.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.core.data.source.local.entity.TvshowEntity

@Database(
    entities = [MovieEntity::class, TvshowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CatalogueDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvshowDao(): TvshowDao

}