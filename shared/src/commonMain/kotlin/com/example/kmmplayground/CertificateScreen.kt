package com.example.kmmplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Jahid on 6/6/23.
 */
@Composable
fun CertificateScreen(navigationState: MutableState<ScreensState>) {

    Box {

        Box(modifier = Modifier.fillMaxSize().background(Color.LightGray))

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
                colorFilter = ColorFilter.tint(color = Color.White),
            )

            Column(
                modifier = Modifier.fillMaxHeight().padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Certificate".uppercase(), style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.Medium, color = Color.Blue
                    )
                )
                Text(
                    text = "Of participation",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Proudly Presented To",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jahid Hasan",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = """
                We give this certificate as a sign that you have attended the .... organized on August 21, 2023. Hopefully, the knowledge from this seminar can be useful.
            """.trimIndent(),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif
                )

            }
        }
    }
}
