package com.example.composemediumexamples.ui.components.atoms

import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
