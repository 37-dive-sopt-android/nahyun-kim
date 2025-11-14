package com.sopt.dive.presentation.signup

data class SignUpUiState(
    val id: String = "",
    val password: String = "",
    val name: String = "",
    val email: String = "",
    val age: String = "" //TODO: Int
)
