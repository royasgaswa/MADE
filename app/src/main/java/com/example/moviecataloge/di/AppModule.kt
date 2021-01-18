package com.example.moviecataloge.di

import com.example.moviecatalogue.core.domain.usecase.CatalogueInteractor
import com.example.moviecatalogue.core.domain.usecase.CatalogueUseCase
import org.koin.dsl.module



val useCaseModule = module {
    factory<CatalogueUseCase>{ CatalogueInteractor(get()) }
}

