package com.sopt.dive.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.presentation.auth.model.ID_KEY
import com.sopt.dive.presentation.auth.model.NICKNAME_KEY
import com.sopt.dive.presentation.auth.model.PASSWORD_KEY
import com.sopt.dive.presentation.auth.model.RegisterInfo
import com.sopt.dive.presentation.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        resultUserInfo = RegisterInfo(
                            id = intent.getStringExtra(ID_KEY).orEmpty(),
                            password = intent.getStringExtra(PASSWORD_KEY).orEmpty(),
                            nickname = intent.getStringExtra(NICKNAME_KEY).orEmpty()
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}