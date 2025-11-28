package com.sopt.dive.data.local.prefs

import android.content.SharedPreferences
import androidx.core.content.edit

private const val USER_ID_KEY = "user_id"
private const val IS_LOGGED_IN_KEY = "auto_login"

//TODO: hilt 사용
class UserPreferences(private val prefs: SharedPreferences) {

    fun saveUserId(id: Long) {
        prefs.edit {
            putLong(USER_ID_KEY, id)
            putBoolean(IS_LOGGED_IN_KEY, true)
            apply()
        }
    }

    fun getUserId() = prefs.getLong(USER_ID_KEY, -1L)

    fun isAutoLogin() = prefs.getBoolean(IS_LOGGED_IN_KEY, false)

    fun logout() {
        prefs.edit {
            clear()
        }
    }
}