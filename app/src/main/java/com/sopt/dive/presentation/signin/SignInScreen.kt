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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.dive.DiveApplication
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicButton
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.ui.component.textfield.LabelTextField
import com.sopt.dive.core.ui.component.textfield.PasswordTextField
import com.sopt.dive.core.util.noRippleClickable

@Composable
fun SignInRoute(
    paddingValues: PaddingValues,
    navigateToMain: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as DiveApplication

    val viewModel: SignInViewModel = viewModel(
        factory = SignInViewModel.provideFactory(app)
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect) {
        viewModel.sideEffect.collect { event ->
            when (event) {
                is LoginSideEffect.NavigateToHome -> navigateToMain()
                is LoginSideEffect.ShowErrorToast -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    SignInScreen(
        modifier = Modifier.padding(paddingValues),
        id = uiState.id,
        password = uiState.password,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = viewModel::tryLogin,
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
                .padding(5.dp)
                .noRippleClickable(onClick = onSignUpClick)
                .padding(top = 5.dp)
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