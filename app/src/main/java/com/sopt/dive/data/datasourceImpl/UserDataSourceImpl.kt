package com.sopt.dive.data.datasourceImpl

import com.sopt.dive.data.datasource.UserDataSource
import com.sopt.dive.data.remote.api.OpenApiService
import com.sopt.dive.data.remote.api.UserApiService
import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto
import com.sopt.dive.data.remote.dto.response.FriendResponseDto
import com.sopt.dive.data.remote.dto.response.ProfileResponseDto

class UserDataSourceImpl(
    private val apiService: UserApiService,
    private val openApiService: OpenApiService
) : UserDataSource {
    override suspend fun signUp(request: SignUpRequestDto): BaseResponse<Unit> =
        apiService.signUp(signUpRequest = request)

    override suspend fun getProfile(userId: Long): BaseResponse<ProfileResponseDto> =
        apiService.getProfile(userId)

    override suspend fun getFriends(): FriendResponseDto =
        openApiService.getFriends()
}