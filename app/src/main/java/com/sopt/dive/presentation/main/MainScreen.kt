package com.sopt.dive.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.sopt.dive.presentation.home.navigation.homeNavGraph
import com.sopt.dive.presentation.main.component.MainBottomBar
import com.sopt.dive.presentation.mypage.navigation.myPageNavGraph
import com.sopt.dive.presentation.search.navigation.searchNavGraph
import com.sopt.dive.presentation.signin.navigation.signInNavGraph
import com.sopt.dive.presentation.signup.navigation.signUpNavGraph
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    navigator: MainNavigator
) {
    val isBottomBarVisible by navigator.isBottomBarVisible.collectAsStateWithLifecycle()
    val currentTab by navigator.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            MainBottomBar(
                visible = isBottomBarVisible,
                tabs = MainTab.entries.toPersistentList(),
                currentTab = currentTab,
                onTabSelected = navigator::navigate
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            homeNavGraph(
                paddingValues = paddingValues
            )

            searchNavGraph(
                paddingValues = paddingValues
            )

            myPageNavGraph(
                paddingValues = paddingValues,
            )

            signInNavGraph(
                paddingValues = paddingValues,
                navigateToMain = navigator::navigateToMyPage,
                navigateToSignUp = navigator::navigateToSignUp,
            )

            signUpNavGraph(
                paddingValues = paddingValues,
                navigateToSignIn = navigator::navigateToSignIn
            )
        }
    }
}