package com.sopt.dive.presentation.signup.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.sopt.dive.core.ui.component.textfield.ErrorLabelTextField
import com.sopt.dive.domain.model.auth.RegisterError

@Composable
internal fun SignUpFormTextField(
    @StringRes titleLabelRes: Int,
    @StringRes placeholderRes: Int,
    value: String,
    onValueChange: (String) -> Unit,
    registerError: RegisterError,
    modifier: Modifier = Modifier
) {
    val isError = value.isNotBlank() && !registerError.validation(value)

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(titleLabelRes),
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        ErrorLabelTextField(
            value = value,
            onValueChange = onValueChange,
            errorMessage = registerError.message,
            isError = isError,
            placeholder = stringResource(placeholderRes),
            visualTransformation = when (registerError) {
                RegisterError.PASSWORD_ERROR -> PasswordVisualTransformation()
                RegisterError.EMAIL_ERROR -> VisualTransformation.None
                else -> VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = when (registerError) {
                    RegisterError.AGE_ERROR -> KeyboardType.Number
                    else -> KeyboardType.Text
                },
                imeAction = when (registerError) {
                    RegisterError.AGE_ERROR -> ImeAction.Done
                    else -> ImeAction.Next
                }
            )
        )
    }
}