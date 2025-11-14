package com.sopt.dive.domain.model.auth

sealed interface LoginResult {
    data object Success : LoginResult
    data class Failure(val errorType: LoginError) : LoginResult
}

enum class LoginError(
    val errorMessage: String
) {
    LOGIN_EMPTY("아이디 또는 비밀번호를 입력해주세요."),
    NOT_REGISTER("회원가입 정보가 없습니다."),
    INVALID_INFO("아이디 또는 비밀번호가 일치하지 않습니다."),
}