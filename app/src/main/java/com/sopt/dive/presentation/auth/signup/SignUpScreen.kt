package com.sopt.dive.presentation.auth.signup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicButton
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.ui.component.textfield.LabelTextField
import com.sopt.dive.core.ui.component.textfield.PasswordTextField
import com.sopt.dive.core.util.AuthValidator


@Composable
fun SignUpRoute(
    modifier: Modifier = Modifier,
    navigateToSignIn: (id: String, password: String) -> Unit
) {
    var idText by remember { mutableStateOf("") }
    var pwdText by remember { mutableStateOf("") }
    var nicknameText by remember { mutableStateOf("") }
    var mbtiText by remember { mutableStateOf("") }

    val context = LocalContext.current

    SignUpScreen(
        modifier = modifier,
        idText = idText,
        pwdText = pwdText,
        nicknameText = nicknameText,
        mbtiText = mbtiText,
        onIdChange = { idText = it},
        onPwdChange = { pwdText = it},
        onNicknameChange = { nicknameText = it},
        onMbtiChange = { mbtiText = it},
        onSignUpClick = {
            if (with(AuthValidator) {
                    validateId(idText)
                    validatePassword(pwdText)
                    validateNickname(nicknameText)
                    validateMbti(mbtiText)
                }) {
                Log.d("SignUp", "정보 보내기")
                navigateToSignIn(idText, pwdText)
            } else {
                Toast.makeText(context, "모든 정보를 정확히 입력해세요.", Toast.LENGTH_SHORT).show()
            }
        }
    )
}

@Composable
private fun SignUpScreen(
    modifier: Modifier = Modifier,
    idText: String,
    pwdText: String,
    nicknameText: String,
    mbtiText: String,
    onIdChange: (String) -> Unit,
    onPwdChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onMbtiChange: (String) -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "SIGN UP",
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(50.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(35.dp),
            modifier = Modifier.weight(1f)
        ) {
            Column {
                Text(
                    text = stringResource(R.string.id_label),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Normal,
                )

                LabelTextField(
                    value = idText,
                    onValueChange = onIdChange,
                    placeholder = stringResource(R.string.id_hint)
                )
            }

            Column {
                Text(
                    text = stringResource(R.string.pwd_label),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Normal,
                )

                PasswordTextField(
                    value = pwdText,
                    onValueChange = onPwdChange,
                    placeholder = stringResource(R.string.pwd_hint)
                )
            }

            Column {
                Text(
                    text = stringResource(R.string.nickname_label),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Normal,
                )

                LabelTextField(
                    value = nicknameText,
                    onValueChange = onNicknameChange,
                    placeholder = stringResource(R.string.nickname_hint)
                )
            }

            Column {
                Text(
                    text = stringResource(R.string.mbti_label),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Normal,
                )

                LabelTextField(
                    value = mbtiText,
                    onValueChange = onMbtiChange,
                    placeholder = stringResource(R.string.mbti_hint)
                )
            }
        }

        DiveBasicButton(
            text = stringResource(R.string.do_signup),
            onClick = onSignUpClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    DiveTheme {
        SignUpScreen(
            idText = "",
            pwdText = "",
            nicknameText = "",
            mbtiText = "",
            onIdChange = {},
            onPwdChange = {},
            onNicknameChange = {},
            onMbtiChange = {},
            onSignUpClick = {}
        )
    }
}