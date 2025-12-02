package com.sopt.dive.data.remote.api

import com.sopt.dive.BuildConfig
import com.sopt.dive.data.remote.dto.response.FriendResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface OpenApiService {
    // 정보 조회
    @GET("/api/users")
    suspend fun getFriends(
        @Header("x-api-key") key: String = BuildConfig.OPEN_API_KEY,
    ): FriendResponseDto
}