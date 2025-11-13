package com.sopt.dive.data.local.di

import android.content.Context
import android.content.SharedPreferences
import com.sopt.dive.data.local.prefs.UserPreferences

private const val SPF_KEY = "spf_key"

class AppContainer(context: Context) {
    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(SPF_KEY, Context.MODE_PRIVATE)

    val userPreferences: UserPreferences = UserPreferences(prefs)
}
