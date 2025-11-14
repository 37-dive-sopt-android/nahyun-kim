package com.sopt.dive.data.datasource

import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.LoginRequestDto
import com.sopt.dive.data.remote.dto.response.LoginResponseDto

interface AuthDataSource {
    suspend fun login(
        request: LoginRequestDto
    ): BaseResponse<LoginResponseDto>
}