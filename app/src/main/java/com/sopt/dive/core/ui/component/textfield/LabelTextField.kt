package com.sopt.dive.core.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.dive.core.designsystem.component.DiveBasicTextField
import com.sopt.dive.core.designsystem.theme.DiveTheme

@Composable
fun LabelTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    DiveBasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions.Default,
        visualTransformation = VisualTransformation.None,
        placeholder = placeholder,
        maxLines = 1
    )
}

@Preview(showBackground = true)
@Composable
private fun LabelTextFieldPreview() {
    DiveTheme {
        var text by remember { mutableStateOf("") }

        LabelTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "placeHolder",
            value = text,
            onValueChange = { text = it }
        )
    }
}