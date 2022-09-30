package com.example.composemediumexamples.ui.components.atoms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composemediumexamples.ui.theme.Purple500

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