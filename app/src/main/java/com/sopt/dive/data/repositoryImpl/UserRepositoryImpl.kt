package com.sopt.dive.data.repositoryImpl

import com.sopt.dive.core.util.suspendRunCatching
import com.sopt.dive.data.datasource.UserDataSource
import com.sopt.dive.data.local.prefs.UserPreferences
import com.sopt.dive.data.mapper.UserRemoteMapper.toModel
import com.sopt.dive.domain.model.auth.UserInfoModel
import com.sopt.dive.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userPreferences: UserPreferences
) : UserRepository {
    override suspend fun getMyProfile(): Result<UserInfoModel> = suspendRunCatching {
        val userId = userPreferences.getUserId()
        userDataSource.getProfile(userId).data!!.toModel()
    }
}