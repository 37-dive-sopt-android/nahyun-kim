package com.sopt.dive.data.di

import com.sopt.dive.data.remote.api.ApiFactory
import com.sopt.dive.data.remote.api.AuthApiService
import com.sopt.dive.data.remote.api.UserApiService

object ServicePool {
    val authApiService: AuthApiService by lazy {
        ApiFactory.create<AuthApiService>()
    }

    val userApiService: UserApiService by lazy {
        ApiFactory.create<UserApiService>()
    }
}