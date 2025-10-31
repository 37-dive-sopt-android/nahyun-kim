package com.sopt.dive.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.sopt.dive.data.local.UserPreferences
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    paddingValues: PaddingValues,
    navigateToAuth: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val context = LocalContext.current
    val userPreferences = remember { UserPreferences(context) }

    LaunchedEffect(Unit) {
        delay(500L)

        if (userPreferences.isAutoLogin()) {
            navigateToHome()
        } else {
            navigateToAuth()
        }
    }

    SplashScreen(
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "DIVE SOPT",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}