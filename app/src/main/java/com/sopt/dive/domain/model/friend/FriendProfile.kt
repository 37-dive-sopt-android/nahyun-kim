package com.sopt.dive.domain.model.friend

import androidx.compose.ui.graphics.Color

data class FriendProfile(
    val profileColor: Color, // TODO: imageUrl로 변경, 일반 프로필과 통합
    val nickname: String,
    val bio: String? = null,
    val profileTag: ProfileTag = ProfileTag.None
)