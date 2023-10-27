package ort.tp3.cars

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ort.tp3.cars.commons.Config

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Config.apiKey = getString(R.string.api_key)
        Config.baseUrl = getString(R.string.base_url)
    }
}