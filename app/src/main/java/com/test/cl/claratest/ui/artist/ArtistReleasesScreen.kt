package com.test.cl.claratest.ui.artist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.cl.claratest.di.AppModule
import com.test.cl.claratest.ui.viewModel.ArtistReleasesViewModel
import com.test.cl.claratest.ui.viewModel.ArtistReleasesViewModelFactory

@Composable
fun ArtistReleasesScreen(artistId: Int) {
    val viewModel: ArtistReleasesViewModel = viewModel(
        factory = ArtistReleasesViewModelFactory(AppModule.getArtistReleasesUseCase, artistId)
    )
    val releases by viewModel.releases.collectAsState()

    var year by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var label by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row {
            TextField(value = year, onValueChange = { year = it }, label = { Text("Year") })
            TextField(value = genre, onValueChange = { genre = it }, label = { Text("Genre") })
            TextField(value = label, onValueChange = { label = it }, label = { Text("Label") })
        }

        Button(onClick = { viewModel.filterReleases(year, genre, label) }) {
            Text("Filter")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(releases) { release ->
                Text(text = "${release.title} (${release.year})")
            }
        }
    }
}