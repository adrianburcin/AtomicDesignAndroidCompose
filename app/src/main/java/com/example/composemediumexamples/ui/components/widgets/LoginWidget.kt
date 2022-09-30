package com.example.composemediumexamples.ui.components.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginWidget() {
    Column(modifier = Modifier.fillMaxSize()) {
        WidgetLoginForm(Modifier.padding(20.dp))
        WidgetEmailForm(Modifier.padding(20.dp))
    }
}