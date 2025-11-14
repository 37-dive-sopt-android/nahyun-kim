package com.sopt.dive.data.datasource

import com.sopt.dive.data.remote.dto.base.BaseResponse
import com.sopt.dive.data.remote.dto.request.SignUpRequestDto

interface UserDataSource {
    suspend fun signUp(
        request: SignUpRequestDto
    ): BaseResponse<Unit>
}