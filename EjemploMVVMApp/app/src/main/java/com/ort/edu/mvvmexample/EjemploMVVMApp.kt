package com.ort.edu.mvvmexample

import android.app.Application
import com.ort.edu.mvvmexample.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EjemploMVVMApp:Application(){
    override fun onCreate() {
        super.onCreate()

        Config.apiKey = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.quotes_api_base_url)
    }
}