package com.sopt.dive.presentation.signin.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.core.navigation.Route
import com.sopt.dive.presentation.signin.SignInRoute
import kotlinx.serialization.Serializable

@Serializable
data object SignIn: Route

fun NavController.navigateToSignIn(
    navOptions: NavOptions? = null
) {
    navigate(
        route = SignIn,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signInNavGraph(
    paddingValues: PaddingValues,
    navigateToMain: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    composable<SignIn> { backStackEntry ->
        SignInRoute(
            paddingValues = paddingValues,
            navigateToMain = navigateToMain,
            navigateToSignUp = navigateToSignUp,
        )
    }
}