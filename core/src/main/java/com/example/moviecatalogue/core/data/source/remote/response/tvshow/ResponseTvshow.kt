package com.example.moviecatalogue.core.data.source.remote.response.tvshow

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseTvshow(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TvshowResponse?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
) : Parcelable