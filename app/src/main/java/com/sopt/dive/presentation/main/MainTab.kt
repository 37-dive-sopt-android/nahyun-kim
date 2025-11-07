package com.sopt.dive.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.sopt.dive.core.navigation.MainTabRoute
import com.sopt.dive.core.navigation.Route
import com.sopt.dive.presentation.home.navigation.Home
import com.sopt.dive.presentation.mypage.navigation.MyPage
import com.sopt.dive.presentation.search.navigation.Search

enum class MainTab(
    val icon: ImageVector,
    val route: MainTabRoute,
    val label: String
) {
    HOME(
        icon = Icons.Default.Home,
        route = Home,
        label = "홈"
    ),
    SEARCH(
        icon = Icons.Default.Search,
        route = Search,
        label = "검색"
    ),
    MY(
        icon = Icons.Default.Person,
        route = MyPage,
        label = "마이"
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
