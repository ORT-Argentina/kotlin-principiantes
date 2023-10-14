package com.example.android.eggtimernotifications

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EggTimerNotificationsApp:Application(){
    override fun onCreate() {
        super.onCreate()
    }
}