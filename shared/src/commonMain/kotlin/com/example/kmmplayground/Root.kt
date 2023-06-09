package com.example.kmmplayground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import com.example.kmmplayground.data.Participant
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun CommonView() {
    val screenNavigationState = remember { mutableStateOf(ScreensState()) }

    val image = remember { mutableStateOf<ImageBitmap?>(null) }


    LaunchedEffect(Unit) {
        image.value = resource("certificate@3x.png").readBytes().toImageBitmap()
    }
    when (val state = screenNavigationState.value.screen) {
        is Screen.CertificateScreen -> CertificateScreen(
            navigationState = screenNavigationState,
            image.value,
            state.participant
        )

        Screen.FormScreen -> FormScreen(screenNavigationState)
    }

}

sealed interface Screen {
    object FormScreen : Screen
    data class CertificateScreen(val participant: Participant) : Screen
}

data class ScreensState(val screen: Screen = Screen.FormScreen)
