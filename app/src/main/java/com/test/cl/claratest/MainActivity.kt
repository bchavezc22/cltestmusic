package com.test.cl.claratest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.test.cl.claratest.di.AppModule
import com.test.cl.claratest.ui.theme.ClaratestTheme
import com.test.cl.claratest.ui.viewModel.MainViewModel
import com.test.cl.claratest.ui.viewModel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(AppModule.searchArtistsUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClaratestTheme {
                NavGraph(viewModel)
            }
        }
    }
}