package com.example.traveapp_kmp.style

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object TravelAppColors {

    val Gray = Color.DarkGray
    val LightGray = Color(100, 100, 100)
    val DarkGray = Color(32, 32, 32)
    val DarkGraySemi = Color(32, 32, 32,150)
    val PreviewImageAreaHoverColor = Color(45, 45, 45)
    val ToastBackground = Color(23, 23, 23)
    val MiniatureColor = Color(50, 50, 50)
    val MiniatureHoverColor = Color(55, 55, 55)
    val Foreground = Color(210, 210, 210)
    val TranslucentBlack = Color(0, 0, 0, 60)
    val TranslucentWhite = Color(255, 255, 255, 20)
    val SemiWhite = Color(255, 255, 255, 30)
    internal val Cultured = Color(0xDD006E72)
    internal val DeepGreenCyanTurquoise = Color(0xFF1B806A)
    internal val FormBackground = Color(0xFF283B61)
    val gradient = Brush.linearGradient(
        colors = listOf(FormBackground, Color.Gray.copy(alpha = .6f)),
        start = Offset.Zero,
        end = Offset.Infinite
    )


    fun buttonBackground(isHover: Boolean) = if (isHover) TranslucentBlack else Color.Transparent
}
