package com.sopt.dive.domain.repository

import com.sopt.dive.domain.model.auth.UserInfoModel

interface UserRepository {
    suspend fun getMyProfile(): Result<UserInfoModel>
}