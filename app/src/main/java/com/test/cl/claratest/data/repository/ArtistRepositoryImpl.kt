package com.test.cl.claratest.data.repository

import com.test.cl.claratest.data.mapper.toDomain
import com.test.cl.claratest.domain.model.Artist
import com.test.cl.claratest.domain.model.ArtistDetail
import com.test.cl.claratest.domain.model.Release
import com.test.cl.claratest.domain.repository.ArtistRepository
import com.test.cl.claratest.remote.DiscogsApiService

class ArtistRepositoryImpl(private val discogsApiService: DiscogsApiService) : ArtistRepository {

    override suspend fun searchArtists(query: String, token: String): List<Artist> {
        return discogsApiService.searchArtists(query, token).results.map { it.toDomain() }
    }

    override suspend fun getArtistDetail(artistId: Int): ArtistDetail {
        return discogsApiService.getArtistDetail(artistId).toDomain()
    }

    override suspend fun getArtistReleases(artistId: Int): List<Release> {
        return discogsApiService.getArtistReleases(artistId).releases.map { it.toDomain() }
    }
}