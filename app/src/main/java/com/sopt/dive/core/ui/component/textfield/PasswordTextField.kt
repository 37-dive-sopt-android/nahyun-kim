package com.sopt.dive.core.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicTextField
import com.sopt.dive.core.designsystem.theme.DiveTheme

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
    )
) {
    var isPwdVisible by remember { mutableStateOf(false) }
    val pwdIconId = remember(isPwdVisible) {
        if (isPwdVisible) R.drawable.ic_password_show else R.drawable.ic_password_hide
    }

    DiveBasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions.Default,
        visualTransformation = if (!isPwdVisible) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = placeholder,
        trailingContent = {
            IconButton(onClick = { isPwdVisible = !isPwdVisible }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = ImageVector.vectorResource(pwdIconId),
                    tint = Color.Gray,
                    contentDescription = null,
                )
            }
        },
        maxLines = 1
    )
}

@Preview(showBackground = true)
@Composable
private fun PasswordTextFieldPreview() {
    DiveTheme {
        var text by remember { mutableStateOf("") }

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "placeHolder",
            value = text,
            onValueChange = { text = it }
        )
    }
}