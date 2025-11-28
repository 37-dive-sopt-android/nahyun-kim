package com.sopt.dive.domain.model.auth

data class UserInfoModel(
    val id: String,
    val name: String,
    val email: String,
    val age: Int
) {
    companion object {
        val Empty = UserInfoModel(
            id = "",
            name = "",
            email = "",
            age = 0
        )

        val Fake = UserInfoModel(
            id = "김나현",
            name = "cocoa",
            email = "test@gmail.com",
            age = 23
        )
    }
}