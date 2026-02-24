package com.test.cl.claratest.domain.model

data class Release(
    val id: Int,
    val title: String,
    val year: Int,
    val genre: List<String>,
    val label: List<String>
)