package com.sopt.dive.presentation.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sopt.dive.core.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data class MyPage(
    val id: String = "",
    val password: String = "",
    val nickname: String = "",
    val mbti: String = ""
) : MainTabRoute

fun NavController.navigateToMyPage(
    userInfo: MyPage,
    navOptions: NavOptions? = null
) {
    navigate(
        route = userInfo,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.myPageNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MyPage> { backStackEntry ->
        _root_ide_package_.com.sopt.dive.presentation.mypage.MyPageRoute(
            paddingValues = paddingValues,
            userInfo = backStackEntry.toRoute<MyPage>(),
        )
    }
}