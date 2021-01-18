package com.example.moviecatalogue.base.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvshowEntityPresentation (
    val id: Int? = null,
    val name: String? = null,
    val firstAirDate: String? = null,
    val rate: Double? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val isFavorite:Boolean
    ):Parcelable