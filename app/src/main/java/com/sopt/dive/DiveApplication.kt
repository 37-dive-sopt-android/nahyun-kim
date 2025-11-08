package com.sopt.dive

import android.app.Application
import com.sopt.dive.data.local.UserPreferences

class DiveApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UserPreferences.init(this)
    }
}