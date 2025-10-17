package com.sopt.dive.core.designsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.dive.core.designsystem.theme.DiveTheme

@Composable
fun DiveBasicTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int,
    modifier: Modifier = Modifier,
    trailingContent: @Composable () -> Unit = {},
    height: Dp = 48.dp,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    Column {
        BasicTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(height),
            value = value,
            textStyle = textStyle,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            maxLines = maxLines,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = textStyle,
                                color = Color.LightGray
                            )
                        }
                        innerTextField()
                    }
                    trailingContent()
                }
            }
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicTextFieldPreview() {
    DiveTheme {
        var text by remember { mutableStateOf("") }

        DiveBasicTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "placeHolder",
            value = text,
            onValueChange = { text = it },
            maxLines = 1,
            trailingContent = {},
        )
    }
}