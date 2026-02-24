package com.test.cl.claratest.ui.viewModel

import android.os.Build
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.test.cl.claratest.domain.model.Artist
import com.test.cl.claratest.domain.usecase.SearchArtistsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val searchArtistsUseCase: SearchArtistsUseCase) : ViewModel() {

    private val _artists = MutableStateFlow<List<Artist>>(emptyList())
    val artists: StateFlow<List<Artist>> = _artists

    fun searchArtists(query: String) {
        viewModelScope.launch {
            try {
                _artists.value = searchArtistsUseCase(query, "YFQVnOiJIsICpjlIRTPbmXYSvOTSHAKyWIAvLWGa")
            } catch (e: Exception) {
                Log.i("MainViewModel", "searchArtists message: ${e.message}")
            }
        }
    }
}

class MainViewModelFactory(private val searchArtistsUseCase: SearchArtistsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(searchArtistsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}