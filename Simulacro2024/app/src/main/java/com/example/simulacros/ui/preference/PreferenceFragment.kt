package com.example.simulacros.ui.preference

import android.content.res.Configuration
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.example.simulacros.R

class PreferenceFragment : PreferenceFragmentCompat() {

    companion object {
        fun newInstance() = PreferenceFragment()
    }

    //private val viewModel: PreferenceViewModel by viewModels()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.default_preference_screen, rootKey)

        val nightMode = findPreference<SwitchPreference>(getString(R.string.preference_night_mode_key));
        nightMode?.setDefaultValue(false)
        nightMode?.setOnPreferenceChangeListener { _, newValue ->
            if (newValue == true) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            true
        }
    }
}