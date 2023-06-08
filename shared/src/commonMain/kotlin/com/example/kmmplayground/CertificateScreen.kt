package com.example.kmmplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.traveapp_kmp.style.TravelAppColors.Cultured
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * Created by Jahid on 6/6/23.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun CertificateScreen(navigationState: MutableState<ScreensState>, value: ImageBitmap?) {

    Box {

        value?.let {
            Image(
                it,
                null,
                modifier = Modifier.fillMaxSize().background(Color.LightGray),
                contentScale = ContentScale.FillBounds,
            )
        }

        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Image(
                imageVector = Filled.ArrowBack,
                contentDescription = "",
                modifier = Modifier.padding(start = 16.dp).clickable(onClick = {
                    navigationState.value = ScreensState(
                        Screen.FormScreen
                    )
                }),
                colorFilter = ColorFilter.tint(color = Color.Gray),
            )

            Column(
                modifier = Modifier.fillMaxHeight().padding(horizontal = 30.dp)
                    .padding(top = 110.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Certificate".uppercase(), style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Normal, color = Cultured, fontSize = 40.sp
                    )
                )
                Text(
                    text = "Of participation".uppercase(),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Proudly Presented To".uppercase(),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jahid Hasan",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    color = Cultured
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = """
                We give this certificate as a sign that you have attended the .... organized on June 13, 2023. Hopefully, the knowledge from this seminar can be useful.
            """.trimIndent(),
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif
                )

            }
        }
    }
}
