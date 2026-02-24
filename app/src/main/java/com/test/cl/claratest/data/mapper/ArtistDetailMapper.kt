package com.test.cl.claratest.data.mapper

import com.test.cl.claratest.data.ArtistDetail as DataArtistDetail
import com.test.cl.claratest.domain.model.ArtistDetail as DomainArtistDetail
import com.test.cl.claratest.domain.model.Member

fun DataArtistDetail.toDomain(): DomainArtistDetail {
    return DomainArtistDetail(
        id = id,
        name = name,
        profile = profile,
        members = members?.map { Member(it.id, it.name) }
    )
}