package com.sopt.dive.data.mapper

import com.sopt.dive.data.remote.dto.response.FriendResult
import com.sopt.dive.data.remote.dto.response.ProfileResponseDto
import com.sopt.dive.domain.model.auth.UserInfoModel
import com.sopt.dive.domain.model.friend.FriendProfile

object UserRemoteMapper {
    fun ProfileResponseDto.toModel() = UserInfoModel(
        id = this.userName,
        name = this.name,
        email = this.email,
        age = this.age
    )

    fun FriendResult.toModel() = FriendProfile(
        profileImage = this.avatar,
        name = "$firstName $lastName "
    )
}