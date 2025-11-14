package com.sopt.dive.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.dive.presentation.home.navigation.Home
import com.sopt.dive.presentation.home.navigation.navigateToHome
import com.sopt.dive.presentation.mypage.navigation.navigateToMyPage
import com.sopt.dive.presentation.search.navigation.navigateToSearch
import com.sopt.dive.presentation.signin.navigation.SignIn
import com.sopt.dive.presentation.signin.navigation.navigateToSignIn
import com.sopt.dive.presentation.signup.navigation.navigateToSignUp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class MainNavigator(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination = SignIn

    private val currentDestination = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val currentTab: StateFlow<MainTab?> = currentDestination
        .map { destination ->
            MainTab.find { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentDestination
        .map { destination ->
            MainTab.contains { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }

        when (tab) {
            MainTab.HOME -> { navController.navigateToHome(navOptions) }
            MainTab.SEARCH -> { navController.navigateToSearch(navOptions) }
            MainTab.MY -> { navController.navigateToMyPage(navOptions) }
        }
    }

    fun navigateToHome() {
        navController.navigateToHome(
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

    fun navigateToSignIn() {
        navController.navigateToSignIn(
            navOptions = navOptions {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        )
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): MainNavigator = remember(navController) {
    MainNavigator(navController, coroutineScope)
}