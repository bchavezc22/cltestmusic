package com.test.cl.claratest.domain.usecase

import com.test.cl.claratest.domain.repository.ArtistRepository

class SearchArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend operator fun invoke(query: String, token: String) = artistRepository.searchArtists(query, token)
}