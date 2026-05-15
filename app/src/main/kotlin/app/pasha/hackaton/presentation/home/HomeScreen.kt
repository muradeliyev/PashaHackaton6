package app.pasha.hackaton.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.pasha.hackaton.core.navigation.Screen
import javax.inject.Inject

class HomeScreen @Inject constructor() : Screen {

    @Composable
    override fun Content() {
        val viewModel = viewModel<HomeViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .clickable {
                    viewModel.goToSecond()
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(state.time.toString(), color = Color.White)
        }
    }
}