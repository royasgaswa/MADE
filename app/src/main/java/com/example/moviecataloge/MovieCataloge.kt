package com.example.moviecataloge

import android.app.Application
import com.example.moviecataloge.di.*
import com.example.moviecatalogue.core.di.databaseModule
import com.example.moviecatalogue.core.di.networkModule
import com.example.moviecatalogue.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieCataloge : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MovieCataloge)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule
                )
            )
        }
    }
}