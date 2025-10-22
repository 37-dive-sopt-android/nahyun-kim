package com.sopt.dive.core.util

object AuthValidator {
    private val idRegex = "[^a-zA-Z0-9가-힣]".toRegex()
    private val passwordRegex = "[^a-zA-Z0-9~!@#\$%^&*]".toRegex()
    private val nicknameRegex = "[^가-힣a-zA-Z0-9]".toRegex()
    private val mbtiRegex = "^[E|I][N|S][F|T][J|P]$".toRegex()

    fun validateId(id: String) = !idRegex.containsMatchIn(id) && id.length in 6 .. 10

    fun validatePassword(password: String) = !passwordRegex.containsMatchIn(password) && password.length in 8 .. 12

    fun validateNickname(nickname: String) = !nicknameRegex.containsMatchIn(nickname) && nickname.isNotBlank()

    fun validateMbti(mbti: String) = mbtiRegex.containsMatchIn(mbti.uppercase())
}