package com.sopt.dive.presentation.auth.model

const val ID_KEY = "ID"
const val PASSWORD_KEY = "PASSWORD"
const val NICKNAME_KEY = "NICKNAME"

data class RegisterInfo(
    val id: String,
    val password: String,
    val nickname: String,
)
