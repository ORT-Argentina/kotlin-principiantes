package com.utn.settingsexample.fragments

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceManager

import com.utn.settingsexample.R
import kotlin.properties.Delegates

class MainFragment : Fragment() {

    lateinit var v : View
    lateinit var btnSettings : Button

    var valor : Int? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.main_fragment, container, false)

        btnSettings = v.findViewById(R.id.btn_settings)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())


        Log.d("Test",prefs.getBoolean("sync",false).toString())
        Log.d("Test",prefs.getString("reply",""))
        Log.d("Test",prefs.getString("signature","default signature"))

        btnSettings.setOnClickListener {

            val action = MainFragmentDirections.actionMainFragmentToSettingsActivity()
            v.findNavController().navigate(action)

        }
    }

}
