package com.sopt.dive.domain.model.auth

import com.sopt.dive.core.util.AuthValidator

enum class RegisterError(
    val message: String,
    val validation: (String) -> Boolean
) {
    ID_ERROR(
        message = "아이디는 영문자와 숫자만 사용할 수 있으며, 1~50자 이내여야 합니다.",
        validation = AuthValidator::validateId
    ),
    PASSWORD_ERROR(
        message = "비밀번호는 8~64자이며, 대문자, 소문자, 숫자, 특수문자를 각각 1자 이상 포함해야 합니다.",
        validation = AuthValidator::validatePassword
    ),
    NAME_ERROR(
        message = "이름은 한글 또는 영문으로 1~100자 이내여야 합니다.",
        validation = AuthValidator::validateName
    ),
    EMAIL_ERROR(
        message = "이메일 형식이 올바르지 않거나 150자를 초과했습니다.",
        validation = AuthValidator::validateEmail
    ),
    AGE_ERROR(
        message = "나이는 0 이상이어야 합니다.",
        validation = AuthValidator::validateAge
    );
}
