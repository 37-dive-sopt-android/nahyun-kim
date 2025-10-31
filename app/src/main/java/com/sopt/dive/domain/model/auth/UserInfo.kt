package com.sopt.dive.domain.model.auth

data class UserInfo(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
)
