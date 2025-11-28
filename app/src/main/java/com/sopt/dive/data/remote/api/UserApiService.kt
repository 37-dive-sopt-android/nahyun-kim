package com.sopt.dive.data.remote.api

import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto
import com.sopt.dive.data.remote.dto.response.ProfileResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApiService {
    // 회원가입
    @POST("/api/v1/users")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequestDto
    ): BaseResponse<Unit>

    // 개인정보 조회
    @GET("/api/v1/users/{id}")
    suspend fun getProfile(
        @Path("id") id: Long
    ): BaseResponse<ProfileResponseDto>
}