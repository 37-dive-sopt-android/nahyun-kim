package com.sopt.dive.domain.model.friend

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf

data class Friend(
    val profileColor: Color,
    val nickname: String,
    val bio: String? = null
)

val dummyFriends = persistentListOf(
    Friend(
        profileColor = Color.Blue,
        nickname = "완두콩 3조",
        bio = "코드리뷰 파이팅!!"
    ),
    Friend(
        profileColor = Color.Yellow,
        nickname = "갓동민",
        bio = "👑"
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
        nickname = "완두콩",
        bio = "떼굴뗴굴"
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
        nickname = "학교 가기 싫어요",
        bio = "휴학 솝트가.. 그렇게 좋다죠??ㅠㅠ"
    ),
    Friend(
        profileColor = Color.Yellow,
        nickname = "살려주세요"
    ),
    Friend(
        profileColor = Color.Green,
        nickname = "잠을자고싶어요",
        bio = "Zzzzzzzzz"
    ),
    Friend(
        profileColor = Color.Magenta,
        nickname = "하루만 집에서 푹 쉴래요"
    ),
)