package com.example.composemediumexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composemediumexamples.ui.theme.ComposeMediumExamplesTheme
import com.example.composemediumexamples.ui.theme.Purple500
import com.example.composemediumexamples.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMediumExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageLogin()
                }
            }
        }
    }
}

@Composable
fun PageLogin() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Authentication")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WidgetLogin()
            }
        })
}

@Composable
fun WidgetLogin() {
    Column(modifier = Modifier.fillMaxSize()) {
        WidgetLoginForm(Modifier.padding(20.dp))
        WidgetEmailForm(Modifier.padding(20.dp))
    }
}

@Composable
fun WidgetLoginForm(modifier: Modifier = Modifier) {
    var tfUsernameValue by remember {
        mutableStateOf("")
    }

    var tfPassowrdValue by remember {
        mutableStateOf("")
    }

    var textValue by remember {
        mutableStateOf("")
    }

    var textColor by remember {
        mutableStateOf(Purple500)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(top = 10.dp, start = 10.dp))
            .then(modifier)
    ) {
        MoleculeTextField(
            value = tfUsernameValue,
            onValueChanged = { tfUsernameValue = it },
            iconVector = Icons.Default.Person,
            label = "Username"
        )
        Spacer(Modifier.height(20.dp))
        MoleculeTextField(
            value = tfPassowrdValue,
            onValueChanged = { tfPassowrdValue = it },
            iconVector = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation(),
            label = "Password"
        )
        Spacer(Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MoleculeButton(text = "Login", onClick = {
                /**
                 * Do some backend api calls stuff and if successful
                 * print the message that the login was successful or not.
                 */
                val isSuccessful = (System.currentTimeMillis() % 2).toInt() == 0
                textValue =
                    "Hello $tfUsernameValue, login was ${if (!isSuccessful) "not " else ""}successful!"
                textColor = if (isSuccessful) {
                    Purple500
                } else {
                    Color.Red
                }
            })
        }
        Spacer(Modifier.height(20.dp))
        AtomText(text = textValue, color = textColor)
    }
}

@Composable
fun WidgetEmailForm(modifier: Modifier = Modifier) {
    var textFieldValue by remember {
        mutableStateOf("")
    }

    var textValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(PaddingValues(top = 10.dp, start = 10.dp))
            .then(modifier)
    ) {
        AtomText(text = "Recover your password. Type in your email address")
        Spacer(Modifier.height(20.dp))
        MoleculeTextField(
            value = textFieldValue,
            onValueChanged = { textFieldValue = it },
            iconVector = Icons.Default.MailOutline
        )
        Spacer(Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MoleculeButton(text = "Send email", onClick = {
                /**
                 * Do some backend api calls stuff and if successful
                 * print the message that the email was sent.
                 */
                textValue = "Email sent to: $textFieldValue!"
            })
        }
        Spacer(Modifier.height(20.dp))
        AtomText(text = textValue)
    }
}

@Composable
fun AtomText(
    modifier: Modifier = Modifier,
    text: String?,
    color: Color = Purple500,
    size: TextUnit = 16.sp
) {
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            style = TextStyle(fontFamily = FontFamily.SansSerif),
            color = color,
            fontSize = size,
            modifier = Modifier
                .padding(PaddingValues(end = 8.dp))
                .then(modifier)
        )
    }
}

@Composable
fun MoleculeTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChanged: ((value: String) -> Unit)? = null,
    iconVector: ImageVector? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    label: String? = null
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChanged?.invoke(it)
        },
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (iconVector != null) {
                Icon(iconVector, contentDescription = null)
            }
        },
        label = {
            /**
             * For demonstration purpose we're not using this label because we're
             * creating our own label
             */
            if (!label.isNullOrEmpty()) {
                AtomText(text = label)
            }
        }
    )
}

@Composable
fun MoleculeButton(
    modifier: Modifier = Modifier,
    text: String = "Click me",
    onClick: (() -> Unit)? = null
) {
    Button(modifier = modifier.width(200.dp), onClick = { onClick?.invoke() }) {
        AtomText(text = text, color = Color.White)
    }
}
