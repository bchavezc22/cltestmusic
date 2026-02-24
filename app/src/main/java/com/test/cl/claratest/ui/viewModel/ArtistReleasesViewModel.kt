package com.test.cl.claratest.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.test.cl.claratest.domain.model.Release
import com.test.cl.claratest.domain.usecase.GetArtistReleasesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArtistReleasesViewModel(
    private val getArtistReleasesUseCase: GetArtistReleasesUseCase,
    private val artistId: Int
) : ViewModel() {

    private val _releases = MutableStateFlow<List<Release>>(emptyList())
    val releases: StateFlow<List<Release>> = _releases

    private var allReleases: List<Release> = emptyList()

    init {
        getArtistReleases()
    }

    private fun getArtistReleases() {
        viewModelScope.launch {
            try {
                allReleases = getArtistReleasesUseCase(artistId).sortedByDescending { it.year }
                _releases.value = allReleases
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun filterReleases(year: String, genre: String, label: String) {
        var filteredList = allReleases

        if (year.isNotBlank()) {
            filteredList = filteredList.filter { it.year.toString() == year }
        }

        if (genre.isNotBlank()) {
            filteredList = filteredList.filter { it.genre.any { it.equals(genre, ignoreCase = true) } }
        }

        if (label.isNotBlank()) {
            filteredList = filteredList.filter { it.label.any { it.equals(label, ignoreCase = true) } }
        }

        _releases.value = filteredList
    }
}

class ArtistReleasesViewModelFactory(
    private val getArtistReleasesUseCase: GetArtistReleasesUseCase,
    private val artistId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistReleasesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArtistReleasesViewModel(getArtistReleasesUseCase, artistId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}