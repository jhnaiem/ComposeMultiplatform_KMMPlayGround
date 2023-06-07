package com.example.kmmplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    Column {
        // To skip upper part of screen.
        Box(
            modifier = Modifier
                .height(40.dp)
        )
        CommonView()
    }
}
