package com.sopt.dive.domain.model.friend

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf

data class Friend(
    val profileColor: Color,
    val nickname: String,
)

val dummyFriends = persistentListOf(
    Friend(
        profileColor = Color.Cyan,
        nickname = "김나현"
    ),
    Friend(
        profileColor = Color.Blue,
        nickname = "완두콩 3조"
    ),
    Friend(
        profileColor = Color.Yellow,
        nickname = "갓동민"
    ),
    Friend(
        profileColor = Color.Magenta,
        nickname = "임차민"
    ),
    Friend(
        profileColor = Color.Red,
        nickname = "성규현"
    ),
    Friend(
        profileColor = Color.Green,
        nickname = "완두콩"
    ),
    Friend(
        profileColor = Color.LightGray,
        nickname = "최고"
    ),
    Friend(
        profileColor = Color.DarkGray,
        nickname = "디솝"
    ),
    Friend(
        profileColor = Color.Yellow,
        nickname = "학교 가기 싫어요"
    ),
    Friend(
        profileColor = Color.Yellow,
        nickname = "살려주세요"
    ),
    Friend(
        profileColor = Color.Green,
        nickname = "잠을자고싶어요"
    ),
    Friend(
        profileColor = Color.Magenta,
        nickname = "하루만 집에서 푹 쉴래요"
    ),
)