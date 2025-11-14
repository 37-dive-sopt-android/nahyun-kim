package com.sopt.dive.core.util

import androidx.core.text.isDigitsOnly

object AuthValidator {
    private val idRegex = "^[a-zA-Z0-9]{1,50}$".toRegex()
    private val passwordRegex =
        """^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[~!@#$%^&*])[A-Za-z\d~!@#$%^&*]{8,64}$""".toRegex()
    private val nameRegex = "^[a-zA-Z가-힣\\s]{1,100}$".toRegex()
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()

    fun validateId(id: String): Boolean =
        id.isNotBlank() && idRegex.matches(id)

    fun validatePassword(password: String): Boolean =
        password.isNotBlank() && passwordRegex.matches(password)

    fun validateName(name: String): Boolean =
        name.isNotBlank() && nameRegex.matches(name)

    fun validateEmail(email: String): Boolean =
        email.isNotBlank() && email.length <= 150 && emailRegex.matches(email)

    fun validateAge(age: String) = age.isDigitsOnly() && age.toInt() >= 0
}
