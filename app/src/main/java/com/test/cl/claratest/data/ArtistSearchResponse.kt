package com.test.cl.claratest.data
import com.squareup.moshi.Json


data class ArtistSearchResponse(
    @Json(name = "results")
    val results: List<Artist>
)