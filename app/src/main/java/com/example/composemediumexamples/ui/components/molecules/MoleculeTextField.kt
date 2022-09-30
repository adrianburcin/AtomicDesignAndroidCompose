package com.example.composemediumexamples.ui.components.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import com.example.composemediumexamples.ui.components.atoms.AtomText

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