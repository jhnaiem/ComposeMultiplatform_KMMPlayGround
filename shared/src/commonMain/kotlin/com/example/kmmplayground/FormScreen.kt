package com.example.kmmplayground

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmplayground.data.Participant
import com.example.traveapp_kmp.style.TravelAppColors.DeepGreenCyanTurquoise
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FormScreen(navigationState: MutableState<ScreensState>) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var participant by remember { mutableStateOf(Participant()) }
    val imageKotlinConf = remember { mutableStateOf<ImageBitmap?>(null) }
    val imageFormBack = remember { mutableStateOf<ImageBitmap?>(null) }


    LaunchedEffect(Unit) {
        imageKotlinConf.value = resource("kotConf@3x.png").readBytes().toImageBitmap()
        imageFormBack.value = resource("formback@3x.png").readBytes().toImageBitmap()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        imageFormBack.value?.let {
            Image(
                it,
                null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
        }
        Column(
            modifier = Modifier.matchParentSize().padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                imageKotlinConf.value?.let {
                    Image(
                        it,
                        null,
                        modifier = Modifier.wrapContentSize(),
                        contentScale = ContentScale.FillBounds,
                    )
                }

                Text(
                    text = "KotlinConf", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold, color = Color.White, fontSize = 30.sp
                    )
                )

            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 50.dp, bottom = 60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    SimpleOutlinedTextFieldSample(onValueChange = {
                        participant = participant.copy(name = it)
                    })

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
                            navigationState.value =
                                ScreensState(screen = Screen.CertificateScreen(participant))
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
}


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
