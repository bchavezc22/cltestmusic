package com.test.cl.claratest.ui.artist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.cl.claratest.di.AppModule
import com.test.cl.claratest.ui.viewModel.ArtistDetailViewModel
import com.test.cl.claratest.ui.viewModel.ArtistDetailViewModelFactory

@Composable
fun ArtistDetailScreen(artistId: Int, onNavigateToReleases: (Int) -> Unit) {
    val viewModel: ArtistDetailViewModel = viewModel(
        factory = ArtistDetailViewModelFactory(AppModule.getArtistDetailUseCase, artistId)
    )
    val artistDetail by viewModel.artistDetail.collectAsState()

    artistDetail?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = it.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.profile)

            it.members?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Members")
                Spacer(modifier = Modifier.height(8.dp))
                it.forEach {
                    Text(text = it.name)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onNavigateToReleases(artistId) }) {
                Text(text = "View Releases")
            }
        }
    }
}