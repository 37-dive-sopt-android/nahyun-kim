package com.sopt.dive.presentation.signup

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicButton
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.ui.component.textfield.ErrorLabelTextField
import com.sopt.dive.domain.model.auth.RegisterError
import com.sopt.dive.presentation.signin.navigation.SignIn


@Composable
fun SignUpRoute(
    paddingValues: PaddingValues,
    navigateToSignIn: (SignIn) -> Unit,
    viewModel: SignUpViewModel = viewModel()
) {
    val context = LocalContext.current
    val userInfo by viewModel.userInfoModel.collectAsStateWithLifecycle()

    SignUpScreen(
        modifier = Modifier.padding(paddingValues),
        id = userInfo.id,
        password = userInfo.password,
        nickname = userInfo.nickname,
        mbti = userInfo.mbti,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onNicknameChange = viewModel::onNicknameChange,
        onMbtiChange = viewModel::onMbtiChange,
        onSignUpClick = {
            if (viewModel.isValid()) {
                navigateToSignIn(SignIn(
                    id = userInfo.id,
                    password = userInfo.password,
                    nickname = userInfo.nickname,
                    mbti = userInfo.mbti
                ))
            } else {
                Toast.makeText(context, "모든 정보를 정확히 입력해세요.", Toast.LENGTH_SHORT).show()
            }
        }
    )
}

@Composable
private fun SignUpScreen(
    modifier: Modifier = Modifier,
    id: String,
    password: String,
    nickname: String,
    mbti: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onMbtiChange: (String) -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 16.dp)
            .imePadding()
    ) {
        Text(
            text = stringResource(R.string.title_activity_login),
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(50.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.weight(1f)
        ) {
            SignUpFormTextField(
                titleLabelRes = R.string.id_label,
                placeholderRes = R.string.id_hint,
                value = id,
                onValueChange = onIdChange,
                registerError = RegisterError.ID_ERROR
            )

            SignUpFormTextField(
                titleLabelRes = R.string.password_label,
                placeholderRes = R.string.password_hint,
                value = password,
                onValueChange = onPasswordChange,
                registerError = RegisterError.PASSWORD_ERROR
            )

            SignUpFormTextField(
                titleLabelRes = R.string.nickname_label,
                placeholderRes = R.string.nickname_hint,
                value = nickname,
                onValueChange = onNicknameChange,
                registerError = RegisterError.NICKNAME_ERROR
            )

            SignUpFormTextField(
                titleLabelRes = R.string.mbti_label,
                placeholderRes = R.string.mbti_hint,
                value = mbti,
                onValueChange = onMbtiChange,
                registerError = RegisterError.MBTI_ERROR
            )
        }

        DiveBasicButton(
            text = stringResource(R.string.do_signup),
            onClick = onSignUpClick
        )
    }
}

@Composable
private fun SignUpFormTextField(
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
                else -> VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                imeAction = when (registerError) {
                    RegisterError.MBTI_ERROR -> ImeAction.Done
                    else -> ImeAction.Next
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    DiveTheme {
        SignUpScreen(
            id = "",
            password = "",
            nickname = "",
            mbti = "",
            onIdChange = {},
            onPasswordChange = {},
            onNicknameChange = {},
            onMbtiChange = {},
            onSignUpClick = {}
        )
    }
}