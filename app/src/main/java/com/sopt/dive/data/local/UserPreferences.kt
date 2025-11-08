package com.sopt.dive.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.sopt.dive.domain.model.auth.UserInfo

//TODO: hilt 사용
object UserPreferences {
    private const val SPF_KEY = "spf_key"
    private const val USER_ID_KEY = "user_id"
    private const val USER_PASSWORD_KEY = "user_password"
    private const val USER_NICKNAME_KEY = "user_nickname"
    private const val USER_MBTI_KEY = "user_mbti"
    private const val IS_LOGGED_IN_KEY = "auto_login"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.applicationContext.getSharedPreferences(SPF_KEY, Context.MODE_PRIVATE)
    }

    fun saveUserInfo(id: String, password: String, nickname: String, mbti: String) {
        prefs.edit {
            putString(USER_ID_KEY, id)
            putString(USER_PASSWORD_KEY, password)
            putString(USER_NICKNAME_KEY, nickname)
            putString(USER_MBTI_KEY, mbti)
            putBoolean(IS_LOGGED_IN_KEY, false)
            apply()
        }
    }

    fun getUserInfo() = UserInfo(
        id = prefs.getString(USER_ID_KEY, "").orEmpty(),
        password = prefs.getString(USER_PASSWORD_KEY, "").orEmpty(),
        nickname = prefs.getString(USER_NICKNAME_KEY, "").orEmpty(),
        mbti = prefs.getString(USER_MBTI_KEY, "").orEmpty()
    )

    fun isAutoLogin() = prefs.getBoolean(IS_LOGGED_IN_KEY, false)

    fun logout() {
        prefs.edit {
            clear()
        }
    }
}