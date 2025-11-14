package com.sopt.dive

import android.app.Application
import com.sopt.dive.data.di.AppContainer

class DiveApplication : Application() {
    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        this.appContainer = AppContainer(this)
    }
}