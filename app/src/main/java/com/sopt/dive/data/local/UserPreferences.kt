package com.sopt.dive.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.sopt.dive.domain.model.auth.UserInfo

class UserPreferences(context: Context) {
    private val spf: SharedPreferences = context.getSharedPreferences(SPF_KEY, Context.MODE_PRIVATE)

    fun saveUserInfo(id: String, password: String, nickname: String, mbti: String) {
        spf.edit {
            putString(USER_ID_KEY, id)
            putString(USER_PASSWORD_KEY, password)
            putString(USER_NICKNAME_KEY, nickname)
            putString(USER_MBTI_KEY, mbti)
            putBoolean(IS_LOGGED_IN_KEY, false)
        }
    }

    fun getUserInfo() = UserInfo(
        id = spf.getString(USER_ID_KEY, "").orEmpty(),
        password = spf.getString(USER_PASSWORD_KEY, "").orEmpty(),
        nickname = spf.getString(USER_NICKNAME_KEY, "").orEmpty(),
        mbti = spf.getString(USER_MBTI_KEY, "").orEmpty()
    )

    fun isAutoLogin() = spf.getBoolean(IS_LOGGED_IN_KEY, false)

    companion object {
        private const val SPF_KEY = "spf_key"
        private const val USER_ID_KEY = "user_id"
        private const val USER_PASSWORD_KEY = "user_password"
        private const val USER_NICKNAME_KEY = "user_nickname"
        private const val USER_MBTI_KEY = "user_mbti"
        private const val IS_LOGGED_IN_KEY = "auto_login"
    }
}