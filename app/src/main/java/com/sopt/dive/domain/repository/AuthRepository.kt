package com.sopt.dive.domain.repository

import com.sopt.dive.domain.model.auth.LoginModel

interface AuthRepository {
    suspend fun login(
        userName: String,
        password: String
    ): Result<LoginModel>

    suspend fun signUp(
        userName: String,
        password: String,
        name: String,
        email: String,
        age: Int
    ): Result<Unit>
}