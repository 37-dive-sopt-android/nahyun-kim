package com.sopt.dive.data.datasourceImpl

import com.sopt.dive.data.datasource.AuthDataSource
import com.sopt.dive.data.remote.api.AuthApiService
import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.LoginRequestDto
import com.sopt.dive.data.remote.dto.response.LoginResponseDto

class AuthDataSourceImpl(
    private val apiService: AuthApiService
): AuthDataSource {
    override suspend fun login(request: LoginRequestDto): BaseResponse<LoginResponseDto> =
        apiService.login(loginRequestDto = request)
}