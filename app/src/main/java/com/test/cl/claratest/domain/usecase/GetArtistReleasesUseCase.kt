package com.test.cl.claratest.domain.usecase

import com.test.cl.claratest.domain.repository.ArtistRepository

class GetArtistReleasesUseCase(private val artistRepository: ArtistRepository) {
    suspend operator fun invoke(artistId: Int) = artistRepository.getArtistReleases(artistId)
}