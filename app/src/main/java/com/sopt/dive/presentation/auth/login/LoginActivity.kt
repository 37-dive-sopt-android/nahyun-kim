package com.sopt.dive.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.presentation.MainActivity
import com.sopt.dive.presentation.auth.model.ID_KEY
import com.sopt.dive.presentation.auth.model.NICKNAME_KEY
import com.sopt.dive.presentation.auth.model.PASSWORD_KEY
import com.sopt.dive.presentation.auth.model.RegisterInfo
import com.sopt.dive.presentation.auth.signup.SignUpActivity

class LoginActivity : ComponentActivity() {
    private var registerId: String by mutableStateOf("")
    private var registerPassword: String by mutableStateOf("")
    private var registerNickname: String by mutableStateOf("")

    private val signupResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            registerId = data?.getStringExtra(ID_KEY) ?: ""
            registerPassword = data?.getStringExtra(PASSWORD_KEY) ?: ""
            registerNickname = data?.getStringExtra(NICKNAME_KEY) ?: ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.ime)
                ) { innerPadding ->
                    LoginRoute(
                        resultUserInfo = RegisterInfo(
                            registerId,
                            registerPassword,
                            registerNickname
                        ),
                        navigateToMain = ::sendUserRegisterInfo,
                        navigateToSignUp = {
                            signupResultLauncher.launch(Intent(this, SignUpActivity::class.java))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun sendUserRegisterInfo(registerInfo: RegisterInfo) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(ID_KEY, registerInfo.id)
            putExtra(PASSWORD_KEY, registerInfo.password)
            putExtra(NICKNAME_KEY, registerInfo.nickname)
        }
        startActivity(intent)
        finish()
    }
}
