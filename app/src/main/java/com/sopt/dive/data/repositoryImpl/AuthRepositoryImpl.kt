package com.sopt.dive.data.repositoryImpl

import com.sopt.dive.core.util.suspendRunCatching
import com.sopt.dive.data.datasource.AuthDataSource
import com.sopt.dive.data.datasource.UserDataSource
import com.sopt.dive.data.local.prefs.UserPreferences
import com.sopt.dive.data.remote.dto.request.LoginRequestDto
import com.sopt.dive.data.mapper.LoginRemoteMapper.toModel
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto
import com.sopt.dive.domain.model.auth.LoginModel
import com.sopt.dive.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val userDataSource: UserDataSource,
    private val userPreferences: UserPreferences
) : AuthRepository {
    override suspend fun login(
        userName: String,
        password: String
    ): Result<LoginModel> = suspendRunCatching {
        val loginResponse = authDataSource.login(
            LoginRequestDto(
                username = userName,
                password = password
            )
        ).data!!

        userPreferences.saveUserId(loginResponse.userId)

        loginResponse.toModel()
    }

    override suspend fun signUp(
        userName: String,
        password: String,
        name: String,
        email: String,
        age: Int
    ): Result<Unit> = suspendRunCatching {
        userDataSource.signUp(
            SignUpRequestDto(
                username = userName,
                password = password,
                name = name,
                email = email,
                age = age
            )
        )
    }
}