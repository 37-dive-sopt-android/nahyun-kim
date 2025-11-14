package com.sopt.dive.domain.model.auth

data class UserInfoModel(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    companion object {
        val Empty = UserInfoModel(
            id = "",
            password = "",
            nickname = "",
            mbti = ""
        )

        val Fake = UserInfoModel(
            id = "id",
            password = "password",
            nickname = "nickname",
            mbti = "INFP"
        )
    }
}