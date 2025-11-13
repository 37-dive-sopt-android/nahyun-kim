package com.sopt.dive

import android.app.Application
import com.sopt.dive.data.local.di.AppContainer
import com.sopt.dive.data.local.prefs.UserPreferences

class DiveApplication : Application() {
    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        this.appContainer = AppContainer(this)
    }
}