package com.sopt.dive.data.datasourceImpl

import com.sopt.dive.data.datasource.UserDataSource
import com.sopt.dive.data.remote.api.UserApiService
import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto

class UserDataSourceImpl(
    private val apiService: UserApiService
) : UserDataSource {
    override suspend fun signUp(request: SignUpRequestDto): BaseResponse<Unit> =
        apiService.signUp(signUpRequest = request)
}