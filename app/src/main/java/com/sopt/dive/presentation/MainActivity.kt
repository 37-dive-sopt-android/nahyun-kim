package com.sopt.dive.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.presentation.main.MainScreen
import com.sopt.dive.presentation.main.rememberMainNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DiveTheme {
                val navigator = rememberMainNavigator()
                MainScreen(
                    navigator = navigator
                )
            }
        }
    }
}