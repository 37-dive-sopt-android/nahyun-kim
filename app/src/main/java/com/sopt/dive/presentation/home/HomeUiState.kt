package com.sopt.dive.presentation.home

import com.sopt.dive.domain.model.auth.UserInfoModel
import com.sopt.dive.domain.model.friend.FriendProfile
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState(
    val myProfile: UserInfoModel = UserInfoModel.Fake,
    val friendList: ImmutableList<FriendProfile> = persistentListOf()
)