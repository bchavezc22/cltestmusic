package com.test.cl.claratest.domain.model

data class ArtistDetail(
    val id: Int,
    val name: String,
    val profile: String,
    val members: List<Member>?
)
