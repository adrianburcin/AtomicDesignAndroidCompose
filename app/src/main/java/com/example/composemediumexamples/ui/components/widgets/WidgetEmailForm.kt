package com.example.composemediumexamples.ui.components.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemediumexamples.ui.components.atoms.AtomText
import com.example.composemediumexamples.ui.components.atoms.MoleculeButton
import com.example.composemediumexamples.ui.components.molecules.MoleculeTextField

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