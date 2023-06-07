package com.example.kmmplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    Box(
        modifier = Modifier.background(gradient)
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 50.dp, bottom = 60.dp)
                .alpha(.6f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                SimpleOutlinedTextFieldSample(onValueChange = { name = it })

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
}

//email id
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleOutlinedTextFieldSample(onValueChange: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
        label = {
            Text(
                "Full Name",
                style = MaterialTheme.typography.body1,
            )
        },
        placeholder = { Text(text = "Full Name") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(1f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}
