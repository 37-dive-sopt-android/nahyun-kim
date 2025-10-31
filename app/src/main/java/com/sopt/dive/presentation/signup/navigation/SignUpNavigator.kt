package com.sopt.dive.presentation.signup.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.core.navigation.Route
import com.sopt.dive.presentation.signin.navigation.SignIn
import com.sopt.dive.presentation.signup.SignUpRoute
import kotlinx.serialization.Serializable

@Serializable
data object SignUp : Route

fun NavController.navigateToSignUp(
    navOptions: NavOptions? = null
) {
    navigate(
        route = SignUp,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signUpNavGraph(
    paddingValues: PaddingValues,
    navigateToSignIn: (SignIn) -> Unit
) {
    composable<SignUp> {
        SignUpRoute(
            navigateToSignIn = navigateToSignIn,
            modifier = Modifier.padding(paddingValues)
        )
    }
}