package com.test.cl.claratest.domain.repository

import com.test.cl.claratest.domain.model.Artist
import com.test.cl.claratest.domain.model.ArtistDetail
import com.test.cl.claratest.domain.model.Release

interface ArtistRepository {
    suspend fun searchArtists(query: String, token: String): List<Artist>
    suspend fun getArtistDetail(artistId: Int): ArtistDetail
    suspend fun getArtistReleases(artistId: Int): List<Release>
}