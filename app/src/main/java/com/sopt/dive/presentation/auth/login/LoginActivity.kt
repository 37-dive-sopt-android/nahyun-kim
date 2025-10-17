package com.sopt.dive.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.presentation.MainActivity
import com.sopt.dive.presentation.auth.model.ID_KEY
import com.sopt.dive.presentation.auth.model.PASSWORD_KEY
import com.sopt.dive.presentation.auth.model.RegisterInfo
import com.sopt.dive.presentation.auth.signup.SignUpActivity

class LoginActivity : ComponentActivity() {
    private var registerId: String by mutableStateOf("")
    private var registerPassword: String by mutableStateOf("")

    private val signupResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            registerId = data?.getStringExtra(ID_KEY) ?: ""
            registerPassword = data?.getStringExtra(PASSWORD_KEY) ?: ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginRoute(
                        resultUserInfo = RegisterInfo(registerId, registerPassword),
                        navigateToLogin = {
                            startActivity(Intent(this, MainActivity::class.java))
                        },
                        navigateToSignUp = {
                            signupResultLauncher.launch(Intent(this, SignUpActivity::class.java))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
