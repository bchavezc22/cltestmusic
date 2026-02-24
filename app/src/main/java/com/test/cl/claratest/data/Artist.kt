package com.test.cl.claratest.data

import com.squareup.moshi.Json

data class Artist(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val name: String,
    @Json(name = "thumb")
    val thumb: String,
    @Json(name = "cover_image")
    val coverImage: String
)