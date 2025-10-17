package com.sopt.dive.presentation.auth.model

const val ID_KEY = "id_key"
const val PASSWORD_KEY = "password_key"

data class RegisterInfo(
    val id: String,
    val password: String
)
