package app.pasha.hackaton.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import app.pasha.hackaton.core.navigation.Navigator
import app.pasha.hackaton.core.navigation.Screen
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppContent @Inject constructor(
    private val navigator: Navigator,
    private val destinations: Set<@JvmSuppressWildcards Screen>,
) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content() {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            topBar = {
                TopAppBar(
                    title = {
                        Text("The app")
                    },
                )
            }
        ) { innerPaddings ->
            NavDisplay(
                backStack = navigator.backStack,
                modifier = Modifier.padding(innerPaddings),
                entryProvider = entryProvider {
                    for (destination in destinations) {
                        addEntryProvider(destination::class) {
                            it.Content()
                        }
                    }
                },
            )
        }
    }
}
