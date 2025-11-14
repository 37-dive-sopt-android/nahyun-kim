package com.sopt.dive.domain.model.auth

data class UserInfoModel(
    val id: String,
    val password: String,
    val nickname: String,
    val email: String,
    val age: Int
) {
    companion object {
        val Empty = UserInfoModel(
            id = "",
            password = "",
            nickname = "",
            email = "",
            age = 0
        )

        val Fake = UserInfoModel(
            id = "id",
            password = "password",
            nickname = "nickname",
            email = "test@gmail.com",
            age = 23
        )
    }
}