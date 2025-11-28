package com.sopt.dive.data.mapper

import com.sopt.dive.data.remote.dto.response.ProfileResponseDto
import com.sopt.dive.domain.model.auth.UserInfoModel

object UserRemoteMapper {
    fun ProfileResponseDto.toModel() = UserInfoModel(
        id = this.userName,
        name = this.name,
        email = this.email,
        age = this.age
    )
}