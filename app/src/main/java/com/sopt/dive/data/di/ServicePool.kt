package com.sopt.dive.data.di

import com.sopt.dive.data.remote.api.ApiFactory
import com.sopt.dive.data.remote.api.AuthApiService

object ServicePool {
    val apiService: AuthApiService by lazy {
        ApiFactory.create<AuthApiService>()
    }
}