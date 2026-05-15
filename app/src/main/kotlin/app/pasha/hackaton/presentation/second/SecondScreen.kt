package app.pasha.hackaton.presentation.second

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import app.pasha.hackaton.core.navigation.Screen
import javax.inject.Inject


class SecondScreen @Inject constructor() : Screen {

    @Composable
    override fun Content() {
        val viewModel = viewModel<SecondViewModel>()


        Box(Modifier.fillMaxSize().background(Color.Gray).clickable {
            viewModel.goBack()
        })
    }
}
