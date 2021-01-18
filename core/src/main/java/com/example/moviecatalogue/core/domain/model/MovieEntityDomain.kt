package com.example.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntityDomain(
    val id: Int? = null,
    val overview: String? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val rate: String? = null,
    val isFavorite:Boolean
) : Parcelable