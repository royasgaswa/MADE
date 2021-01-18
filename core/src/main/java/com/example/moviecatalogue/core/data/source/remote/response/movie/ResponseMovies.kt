package com.example.moviecatalogue.core.data.source.remote.response.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMovies(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieResponse?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
) : Parcelable


