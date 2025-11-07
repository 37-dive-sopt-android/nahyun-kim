package com.sopt.dive.domain.model.auth

data class UserInfo(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) {
    companion object {
        val Empty = UserInfo(
            id = "",
            password = "",
            nickname = "",
            mbti = ""
        )

        val Fake = UserInfo(
            id = "id",
            password = "password",
            nickname = "nickname",
            mbti = "INFP"
        )
    }
}
