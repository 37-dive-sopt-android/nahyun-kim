package com.sopt.dive.data.remote.api

import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.LoginRequestDto
import com.sopt.dive.data.remote.dto.response.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    // 로그인
    @POST("/api/v1/auth/login")
    suspend fun login(
        @Body loginRequestDto: LoginRequestDto
    ): BaseResponse<LoginResponseDto>
}