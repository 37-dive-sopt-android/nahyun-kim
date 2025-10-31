package com.sopt.dive.model.auth

import com.sopt.dive.core.util.AuthValidator

enum class RegisterError(
    val message: String,
    val validation: (String) -> Boolean
) {
    ID_ERROR(
        message = "아이디는 6~10자, 영문, 숫자, 한글만 가능합니다.",
        validation = AuthValidator::validateId
    ),
    PASSWORD_ERROR(
        message = "비밀번호는 8~12자, 영문, 숫자 또는 특수문자(~!@#$%^&*)만 가능합니다.",
        validation = AuthValidator::validatePassword
    ),
    NICKNAME_ERROR(
        message = "닉네임은 영문, 숫자, 한글만 가능합니다.",
        validation = AuthValidator::validateNickname
    ),
    MBTI_ERROR(
        message = "MBTI 형식에 맞지 않습니다.",
        validation = AuthValidator::validateMbti
    )
}