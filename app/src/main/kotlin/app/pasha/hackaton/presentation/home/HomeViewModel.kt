package app.pasha.hackaton.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pasha.hackaton.core.mvi.Stateful
import app.pasha.hackaton.core.mvi.statefulViewModel
import app.pasha.hackaton.core.navigation.Navigator
import app.pasha.hackaton.presentation.second.SecondScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(),
    Stateful<HomeState> by statefulViewModel(HomeState(0)) {

    init {
        viewModelScope.launch {
            while (isActive) {
                updateState { it.copy(time = it.time + 1) }
                delay(1000)
            }
        }
    }

    fun goToSecond() {
        navigator.navigateTo(SecondScreen())
    }
}
