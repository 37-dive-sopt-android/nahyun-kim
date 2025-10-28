package com.sopt.dive.core.ui.component.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.core.designsystem.component.DiveBasicTextField
import com.sopt.dive.core.designsystem.theme.DiveTheme

@Composable
fun ErrorLabelTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    errorMessage: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        DiveBasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions.Default,
            visualTransformation = visualTransformation,
            placeholder = placeholder,
            maxLines = 1,
        )

        Text(
            text = errorMessage,
            fontSize = 10.sp,
            color = Color.Red,
            modifier = Modifier
                .padding(top = 2.dp)
                .alpha(if (isError) 1f else 0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabelTextFieldPreview() {
    DiveTheme {
        var text by remember { mutableStateOf("") }

        ErrorLabelTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "placeHolder",
            value = text,
            isError = true,
            errorMessage = "id가 조건에 맞지 않습니다.",
            onValueChange = { text = it }
        )
    }
}