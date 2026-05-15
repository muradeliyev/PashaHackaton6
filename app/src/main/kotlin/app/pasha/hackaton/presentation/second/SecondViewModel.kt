package app.pasha.hackaton.presentation.second

import androidx.lifecycle.ViewModel
import app.pasha.hackaton.core.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SecondViewModel @Inject constructor(private val navigator: Navigator) : ViewModel() {

    fun goBack() {
        navigator.back()
    }
}