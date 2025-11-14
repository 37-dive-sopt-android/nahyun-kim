package com.sopt.dive.data.remote.api

import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    // 회원가입
    @POST("/api/v1/users")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequestDto
    ): BaseResponse<Unit>
}