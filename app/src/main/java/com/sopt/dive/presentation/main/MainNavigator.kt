package com.sopt.dive.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.dive.presentation.mypage.navigation.MyPage
import com.sopt.dive.presentation.mypage.navigation.navigateToMyPage
import com.sopt.dive.presentation.signin.navigation.SignIn
import com.sopt.dive.presentation.signin.navigation.navigateToSignIn
import com.sopt.dive.presentation.signup.navigation.navigateToSignUp

class MainNavigator(
    val navController: NavHostController,
) {
    val startDestination = SignIn()

    fun navigateToMyPage(
        userInfo: MyPage
    ) {
        navController.navigateToMyPage(
            userInfo = userInfo,
            navOptions = navOptions {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        )
    }

    fun navigateToSignUp() {
        navController.navigateToSignUp()
    }

    fun navigateToSignIn(
        registerInfo: SignIn?
    ) {
        navController.navigateToSignIn(
            registerInfo = registerInfo
        )
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}