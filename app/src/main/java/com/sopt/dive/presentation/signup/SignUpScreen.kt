package com.sopt.dive.presentation.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.dive.DiveApplication
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.component.DiveBasicButton
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.domain.model.auth.RegisterError
import com.sopt.dive.presentation.signup.component.SignUpFormTextField


@Composable
fun SignUpRoute(
    paddingValues: PaddingValues,
    navigateToSignIn: () -> Unit,
) {
    val context = LocalContext.current
    val app = context.applicationContext as DiveApplication

    val viewModel: SignUpViewModel = viewModel(
        factory = SignUpViewModel.provideFactory(app)
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect) {
        viewModel.sideEffect.collect { event ->
            when (event) {
                is SignUpSideEffect.NavigateToSignIn -> {
                    Toast.makeText(context, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    navigateToSignIn()
                }
                is SignUpSideEffect.ShowToast -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    SignUpScreen(
        modifier = Modifier.padding(paddingValues),
        id = uiState.id,
        password = uiState.password,
        email = uiState.email,
        name = uiState.name,
        age = uiState.age,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onEmailChange = viewModel::onEmailChange,
        onNameChange = viewModel::onNameChange,
        onAgeChange = viewModel::onAgeChange,
        onSignUpClick = viewModel::trySignUp
    )
}

@Composable
private fun SignUpScreen(
    modifier: Modifier = Modifier,
    id: String,
    password: String,
    email: String,
    name: String,
    age: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 16.dp)
            .imePadding()
    ) {
        Text(
            text = stringResource(R.string.sign_up_title),
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            contentPadding = PaddingValues(top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.weight(1f)
        ) {
            item {
                SignUpFormTextField(
                    titleLabelRes = R.string.id_label,
                    placeholderRes = R.string.id_hint,
                    value = id,
                    onValueChange = onIdChange,
                    registerError = RegisterError.ID_ERROR
                )
            }

            item {
                SignUpFormTextField(
                    titleLabelRes = R.string.password_label,
                    placeholderRes = R.string.password_hint,
                    value = password,
                    onValueChange = onPasswordChange,
                    registerError = RegisterError.PASSWORD_ERROR
                )
            }

            item {
                SignUpFormTextField(
                    titleLabelRes = R.string.name_label,
                    placeholderRes = R.string.name_hint,
                    value = name,
                    onValueChange = onNameChange,
                    registerError = RegisterError.NAME_ERROR
                )
            }

            item {
                SignUpFormTextField(
                    titleLabelRes = R.string.email_label,
                    placeholderRes = R.string.email_hint,
                    value = email,
                    onValueChange = onEmailChange,
                    registerError = RegisterError.EMAIL_ERROR
                )
            }

            item {
                SignUpFormTextField(
                    titleLabelRes = R.string.age_label,
                    placeholderRes = R.string.age_hint,
                    value = age,
                    onValueChange = onAgeChange,
                    registerError = RegisterError.AGE_ERROR
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
private fun SignUpScreenPreview() {
    DiveTheme {
        SignUpScreen(
            id = "",
            password = "",
            email = "",
            name = "",
            age = "",
            onIdChange = {},
            onPasswordChange = {},
            onEmailChange = {},
            onNameChange = {},
            onAgeChange = {},
            onSignUpClick = {}
        )
    }
}