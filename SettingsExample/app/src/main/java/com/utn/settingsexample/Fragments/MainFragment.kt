package com.utn.settingsexample.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import com.utn.settingsexample.R

class MainFragment : Fragment() {

    lateinit var v : View
    lateinit var btnSettings : Button

    var valor : Int? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            v = inflater.inflate(R.layout.main_fragment, container, false)

            btnSettings = v.findViewById(R.id.btn_settings)

        return v
    }

    override fun onStart() {
        super.onStart()

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())

        Log.d("Test",prefs.getBoolean("sync",false).toString())
        Log.d("Test",prefs.getString("reply_string",""))
        Log.d("Test",prefs.getString("signature_string","default signature"))
        Log.d("Test",prefs.getString("edit_text_preference_1","aca no hay nada"))

        btnSettings.setOnClickListener {

            val action = MainFragmentDirections.actionMainFragmentToSettingsActivity()
            v.findNavController().navigate(action)

        }
    }

}
