package com.sopt.dive.data.di

import android.content.Context
import android.content.SharedPreferences
import com.sopt.dive.data.datasource.AuthDataSource
import com.sopt.dive.data.datasourceImpl.AuthDataSourceImpl
import com.sopt.dive.data.local.prefs.UserPreferences
import com.sopt.dive.data.repositoryImpl.AuthRepositoryImpl
import com.sopt.dive.domain.repository.AuthRepository

private const val SPF_KEY = "spf_key"

class AppContainer(context: Context) {
    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(SPF_KEY, Context.MODE_PRIVATE)

    private val authDataSource: AuthDataSource = AuthDataSourceImpl(ServicePool.apiService)
    val userPreferences: UserPreferences = UserPreferences(prefs)

    val authRepository: AuthRepository = AuthRepositoryImpl(authDataSource, userPreferences)
}
