package ar.edu.ort.tp3.myapplication.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ar.edu.ort.tp3.myapplication.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}