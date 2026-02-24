package com.test.cl.claratest.data.mapper

import com.test.cl.claratest.data.Release as DataRelease
import com.test.cl.claratest.domain.model.Release as DomainRelease

fun DataRelease.toDomain(): DomainRelease {
    return DomainRelease(
        id = id,
        title = title,
        year = year,
        genre = genre,
        label = label
    )
}