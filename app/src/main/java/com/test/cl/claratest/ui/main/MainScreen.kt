package com.test.cl.claratest.ui.main

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.test.cl.claratest.domain.model.Artist
import com.test.cl.claratest.ui.viewModel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel, onArtistClick: (Artist) -> Unit) {
    val artists by viewModel.artists.collectAsState()
    var query by remember { mutableStateOf("") }

    MainScreenContent(
        artists = artists,
        query = query,
        onQueryChange = { newQuery ->
            query = newQuery
        },
        onSearchClick = {
            viewModel.searchArtists(query)
        },
        onArtistClick = onArtistClick
    )
}

@Composable
fun ArtistListItem(artist: Artist, onArtistClick: (Artist) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onArtistClick(artist) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(artist.thumb),
            contentDescription = artist.name,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = artist.name)
    }
}

@Composable
fun MainScreenContent(
    artists: List<Artist>,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onArtistClick: (Artist) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search for an artist") },
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = onSearchClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_search),
                    contentDescription = "Search"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (artists.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Search for an artist")
            }
        } else {
            LazyColumn {
                items(artists) { artist ->
                    ArtistListItem(artist = artist, onArtistClick = onArtistClick)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val sampleArtists = listOf(
        Artist(id = 1, name = "The Beatles", thumb = ""),
        Artist(id = 2, name = "Queen", thumb = ""),
        Artist(id = 3, name = "Led Zeppelin", thumb = "")
    )
    MainScreenContent(
        artists = sampleArtists,
        query = "rock",
        onQueryChange = {},
        onSearchClick = {},
        onArtistClick = {}
    )
}