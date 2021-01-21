package com.example.moviecatalogue.core.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName


data class ResponseTvShow(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TvShowResponse?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)