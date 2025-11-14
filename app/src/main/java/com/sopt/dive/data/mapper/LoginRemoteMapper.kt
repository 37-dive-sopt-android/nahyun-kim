package com.sopt.dive.data.mapper

import com.sopt.dive.data.remote.dto.response.LoginResponseDto
import com.sopt.dive.domain.model.auth.LoginModel

object LoginRemoteMapper {
    // 로그인
    fun LoginResponseDto.toModel() =
        LoginModel(
            userId = this.userId,
            message = this.message
        )
}