package com.test.cl.claratest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.test.cl.claratest.ui.artist.ArtistDetailScreen
import com.test.cl.claratest.ui.artist.ArtistReleasesScreen
import com.test.cl.claratest.ui.main.MainScreen
import com.test.cl.claratest.ui.viewModel.MainViewModel

@Composable
fun NavGraph(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(viewModel = mainViewModel, onArtistClick = {
                navController.navigate("artist/${it.id}")
            })
        }
        composable(
            "artist/{artistId}",
            arguments = listOf(navArgument("artistId") { type = NavType.IntType })
        ) {
            val artistId = it.arguments?.getInt("artistId")
            artistId?.let {
                ArtistDetailScreen(artistId = it, onNavigateToReleases = {
                    navController.navigate("artist/${it}/releases")
                })
            }
        }
        composable(
            "artist/{artistId}/releases",
            arguments = listOf(navArgument("artistId") { type = NavType.IntType })
        ) {
            val artistId = it.arguments?.getInt("artistId")
            artistId?.let {
                ArtistReleasesScreen(artistId = it)
            }
        }
    }
}