package com.sopt.dive.presentation.signin

import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicButton
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.ui.component.textfield.LabelTextField
import com.sopt.dive.core.ui.component.textfield.PasswordTextField
import com.sopt.dive.core.util.noRippleClickable
import com.sopt.dive.data.local.UserPreferences
import com.sopt.dive.presentation.signin.navigation.SignIn

@Composable
fun SignInRoute(
    paddingValues: PaddingValues,
    registerUserInfo: SignIn?,
    navigateToMain: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    val context = LocalContext.current
    val userPreferences = remember { UserPreferences(context) }

    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    SignInScreen(
        modifier = Modifier.padding(paddingValues),
        id = id,
        password = password,
        onIdChange = { id = it },
        onPasswordChange = { password = it },
        onLoginClick = {
            if (id.isBlank() || password.isBlank()) {
                Toast.makeText(context, "아이디 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@SignInScreen
            }

            if (registerUserInfo == null) {
                Toast.makeText(context, "회원가입 정보가 없습니다.", Toast.LENGTH_SHORT).show()
                return@SignInScreen
            }

            if (registerUserInfo.id == id && registerUserInfo.password == password) {
                userPreferences.saveUserInfo(
                    id = id,
                    password = password,
                    nickname = registerUserInfo.nickname,
                    mbti = registerUserInfo.mbti
                )
                navigateToMain()
            } else {
                Toast.makeText(context, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        },
        onSignUpClick = navigateToSignUp
    )
}

@Composable
private fun SignInScreen(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 16.dp)
            .imePadding()
    ) {
        Text(
            text = stringResource(R.string.auth_welcome),
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(50.dp))

        Text(
            text = stringResource(R.string.id_label),
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        LabelTextField(
            value = id,
            onValueChange = onIdChange,
            placeholder = stringResource(R.string.id_hint),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        Spacer(Modifier.height(30.dp))

        Text(
            text = stringResource(R.string.password_label),
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        PasswordTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = stringResource(R.string.password_hint),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )

        Spacer(Modifier.weight(1f))

        DiveBasicButton(
            text = stringResource(R.string.auth_welcome),
            onClick = onLoginClick
        )

        Text(
            text = stringResource(R.string.do_signup),
            fontSize = 14.sp,
            style = TextStyle(fontWeight = FontWeight.Medium),
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
                .noRippleClickable(onClick = onSignUpClick)
                .padding(5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    DiveTheme {
        SignInScreen(
            id = "",
            password = "",
            onIdChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onSignUpClick = {}
        )
    }
}