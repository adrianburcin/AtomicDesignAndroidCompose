package com.example.composemediumexamples.ui.components.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemediumexamples.ui.components.widgets.WidgetEmailForm
import com.example.composemediumexamples.ui.components.widgets.WidgetLoginForm

@Composable
fun LoginPage() {
    Column(modifier = Modifier.fillMaxSize()) {
        WidgetLoginForm(Modifier.padding(20.dp))
        WidgetEmailForm(Modifier.padding(20.dp))
    }
}