package com.sopt.dive.domain.model.friend

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf

data class FriendProfile(
    val profileColor: Color, // TODO: imageUrl로 변경, 일반 프로필과 통합
    val nickname: String,
    val bio: String? = null,
    val profileTag: ProfileTag = ProfileTag.None
)

val dummyFriendProfiles = persistentListOf(
    FriendProfile(
        profileColor = Color.Blue,
        nickname = "완두콩 3조",
        bio = "코드리뷰 파이팅!!"
    ),
    FriendProfile(
        profileColor = Color.Yellow,
        nickname = "갓동민",
        bio = "👑",
        profileTag = ProfileTag.Music(
            musicName = "Kyo181",
            musicAuthor = "실리카겔"
        )
    ),
    FriendProfile(
        profileColor = Color.Magenta,
        nickname = "임차민",
        profileTag = ProfileTag.Birthday
    ),
    FriendProfile(
        profileColor = Color.Red,
        nickname = "성규현"
    ),
    FriendProfile(
        profileColor = Color.Green,
        nickname = "완두콩",
        bio = "떼굴뗴굴",
        profileTag = ProfileTag.Music(
            musicName = "Thunder",
            musicAuthor = "Imagine Dragons"
        )
    ),
    FriendProfile(
        profileColor = Color.LightGray,
        nickname = "최고"
    ),
    FriendProfile(
        profileColor = Color.DarkGray,
        nickname = "디솝"
    ),
    FriendProfile(
        profileColor = Color.Yellow,
        nickname = "학교 가기 싫어요",
        bio = "휴학 솝트가.. 그렇게 좋다죠??ㅠㅠ",
        profileTag = ProfileTag.Birthday
    ),
    FriendProfile(
        profileColor = Color.Yellow,
        nickname = "살려주세요"
    ),
    FriendProfile(
        profileColor = Color.Green,
        nickname = "잠을자고싶어요",
        bio = "Zzzzzzzzz"
    ),
    FriendProfile(
        profileColor = Color.Magenta,
        nickname = "하루만 집에서 푹 쉴래요"
    ),
)