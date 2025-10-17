package com.sopt.dive.presentation.auth.signup

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.presentation.auth.login.LoginActivity
import com.sopt.dive.presentation.auth.model.ID_KEY
import com.sopt.dive.presentation.auth.model.NICKNAME_KEY
import com.sopt.dive.presentation.auth.model.PASSWORD_KEY

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpRoute(
                        modifier =  Modifier.padding(innerPadding),
                        navigateToSignIn = ::sendUserRegisterInfo
                    )
                }
            }
        }
    }

    private fun sendUserRegisterInfo(id: String, password: String, nickname: String) {
        val intent = Intent(this, LoginActivity::class.java)
            .putExtra(ID_KEY, id)
            .putExtra(PASSWORD_KEY, password)
            .putExtra(NICKNAME_KEY, nickname)
        setResult(RESULT_OK, intent)
        finish()
    }
}