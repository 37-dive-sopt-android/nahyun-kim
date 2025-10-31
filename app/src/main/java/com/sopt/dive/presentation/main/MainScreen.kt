package com.sopt.dive.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.sopt.dive.presentation.mypage.navigation.myPageNavGraph
import com.sopt.dive.presentation.signin.navigation.signInNavGraph
import com.sopt.dive.presentation.signup.navigation.signUpNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator,
) {
    Scaffold { paddingValues ->
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            signInNavGraph(
                paddingValues = paddingValues,
                navigateToMain = navigator::navigateToMyPage,
                navigateToSignUp = navigator::navigateToSignUp,
            )

            signUpNavGraph(
                paddingValues = paddingValues,
                navigateToSignIn = navigator::navigateToSignIn
            )

            myPageNavGraph(
                paddingValues = paddingValues,
            )
        }
    }
}