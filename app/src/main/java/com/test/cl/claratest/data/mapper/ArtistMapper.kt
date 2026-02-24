package com.test.cl.claratest.data.mapper

import com.test.cl.claratest.data.Artist as DataArtist
import com.test.cl.claratest.domain.model.Artist as DomainArtist

fun DataArtist.toDomain(): DomainArtist {
    return DomainArtist(
        id = this.id,
        name = this.name,
        thumb = this.thumb
    )
}