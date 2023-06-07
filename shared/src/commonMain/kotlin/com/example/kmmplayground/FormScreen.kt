package com.example.kmmplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FormScreen(navigationState: MutableState<ScreensState>) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Cyan.copy(alpha = .3f), Color.Gray.copy(alpha = .6f)),
        start = Offset.Zero,
        end = Offset.Infinite
    )
    val DeepGreenCyanTurquoise = Color(0xFF1B806A)
    Card(
        modifier = Modifier.background(gradient)
            .padding(vertical = 50.dp, horizontal = 20.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 4.dp
    ) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 15.dp)
                .padding(top = 20.dp)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("Id") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navigationState.value = ScreensState(screen = Screen.CertificateScreen)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DeepGreenCyanTurquoise,
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Proceed",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
