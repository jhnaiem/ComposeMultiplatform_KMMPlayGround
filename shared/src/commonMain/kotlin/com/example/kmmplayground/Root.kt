package com.example.kmmplayground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun CommonView() {
    val screenNavigationState = remember { mutableStateOf(ScreensState()) }


    when (val state = screenNavigationState.value.screen) {
        is Screen.CertificateScreen -> CertificateScreen(
            navigationState = screenNavigationState
        )
        Screen.FormScreen -> FormScreen(screenNavigationState)
    }

}

sealed interface Screen {
    object FormScreen : Screen
    object CertificateScreen : Screen
}

data class ScreensState(val screen: Screen = Screen.FormScreen)
