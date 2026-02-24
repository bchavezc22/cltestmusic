package com.test.cl.claratest.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.test.cl.claratest.domain.model.ArtistDetail
import com.test.cl.claratest.domain.usecase.GetArtistDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArtistDetailViewModel(private val getArtistDetailUseCase: GetArtistDetailUseCase, private val artistId: Int) : ViewModel() {

    private val _artistDetail = MutableStateFlow<ArtistDetail?>(null)
    val artistDetail: StateFlow<ArtistDetail?> = _artistDetail

    init {
        getArtistDetail()
    }

    private fun getArtistDetail() {
        viewModelScope.launch {
            try {
                _artistDetail.value = getArtistDetailUseCase(artistId)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

class ArtistDetailViewModelFactory(private val getArtistDetailUseCase: GetArtistDetailUseCase, private val artistId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArtistDetailViewModel(getArtistDetailUseCase, artistId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}