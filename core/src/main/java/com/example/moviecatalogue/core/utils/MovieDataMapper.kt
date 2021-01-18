 package com.example.moviecatalogue.core.utils

 import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
 import com.example.moviecatalogue.core.data.source.remote.response.movie.MovieResponse
 import com.example.moviecatalogue.core.domain.model.MovieEntityDomain


 object MovieDataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse?>): List<MovieEntity> {
        val movieList=ArrayList<MovieEntity>()
        input.map {
            val movie=MovieEntity(
                id =it?.id,
                overview = it?.overview,
                title = it?.title,
                path = it?.posterPath,
                backdropPath = it?.backdropPath,
                date = it?.releaseDate,
                rate = it?.rate,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

     fun mapEntitiesToDomain(input: List<MovieEntity>):List<MovieEntityDomain> =
         input.map {
             MovieEntityDomain(
                 id = it.id,
                 overview = it.overview,
                 title = it.title,
                 posterPath = it.path,
                 backdropPath = it.backdropPath,
                 releaseDate = it.date,
                 rate = it.rate,
                 isFavorite = it.favorite
             )
         }
     fun mapDomainToPresentation(input: List<MovieEntityDomain>):List<com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation> =
         input.map {
             com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation(
                 id = it.id,
                 overview = it.overview,
                 title = it.title,
                 posterPath = it.posterPath,
                 backdropPath = it.backdropPath,
                 releaseDate = it.releaseDate,
                 rate = it.rate,
                 isFavorite = it.isFavorite
             )
         }
     fun mapDomainToEntity(input:MovieEntityDomain)=MovieEntity(
         id = input.id,
         overview = input.overview,
         title = input.title,
         path = input.posterPath,
         backdropPath = input.backdropPath,
         date = input.releaseDate,
         rate = input.rate,
         favorite = input.isFavorite
     )

     fun mapPresentationToDomain(input: com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation)=MovieEntityDomain(
         id = input.id,
         overview = input.overview,
         title = input.title,
         posterPath = input.posterPath,
         backdropPath = input.backdropPath,
         releaseDate = input.releaseDate,
         rate = input.rate,
         isFavorite = input.isFavorite
     )

}