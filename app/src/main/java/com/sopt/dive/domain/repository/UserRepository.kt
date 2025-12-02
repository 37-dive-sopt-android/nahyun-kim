package com.sopt.dive.domain.repository

import com.sopt.dive.domain.model.auth.UserInfoModel
import com.sopt.dive.domain.model.friend.FriendProfile

interface UserRepository {
    suspend fun getMyProfile(): Result<UserInfoModel>

    suspend fun getFriends(): Result<List<FriendProfile>>
}