package com.manadigital.navigation2.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

import com.manadigital.navigation2.R
import com.manadigital.navigation2.fragments.Entities.User

/**
 * A simple [Fragment] subclass.
 */
class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var user : User
    lateinit var lblNombre : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=  inflater.inflate(R.layout.fragment_fragment2, container, false)
        lblNombre = v.findViewById(R.id.lbl_main_name)
        return v
    }

    override fun onStart() {
        super.onStart()

        user = Fragment2Args.fromBundle(requireArguments()).user

        var usuario = Fragment2Args.fromBundle(requireArguments()).usuario

        lblNombre.text = user.email

        Snackbar.make(v,user.email,Snackbar.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()


    }
}
