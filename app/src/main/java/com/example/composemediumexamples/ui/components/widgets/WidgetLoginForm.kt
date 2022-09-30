package com.example.composemediumexamples.ui.components.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.composemediumexamples.ui.components.atoms.AtomText
import com.example.composemediumexamples.ui.components.atoms.MoleculeButton
import com.example.composemediumexamples.ui.components.molecules.MoleculeTextField
import com.example.composemediumexamples.ui.theme.Purple500

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