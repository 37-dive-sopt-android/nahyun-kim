package com.sopt.dive.presentation.signin.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sopt.dive.core.navigation.Route
import com.sopt.dive.presentation.mypage.navigation.MyPage
import kotlinx.serialization.Serializable

@Serializable
data class SignIn(
    val id: String = "",
    val password: String = "",
    val nickname: String = "",
    val mbti: String = ""
) : Route

fun NavController.navigateToSignIn(
    registerInfo: SignIn?,
    navOptions: NavOptions? = null
) {
    navigate(
        route = registerInfo ?: SignIn(),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signInNavGraph(
    paddingValues: PaddingValues,
    navigateToMain: (MyPage) -> Unit,
    navigateToSignUp: () -> Unit
) {
    composable<SignIn> { backStackEntry ->
        _root_ide_package_.com.sopt.dive.presentation.signin.SignInRoute(
            registerUserInfo = backStackEntry.toRoute<SignIn>(),
            navigateToMain = navigateToMain,
            navigateToSignUp = navigateToSignUp,
            modifier = Modifier.padding(paddingValues)
        )
    }
}