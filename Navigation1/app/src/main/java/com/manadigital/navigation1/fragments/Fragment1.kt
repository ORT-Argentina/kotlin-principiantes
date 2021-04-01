package com.manadigital.navigation1.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.manadigital.navigation1.R

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    lateinit var v: View
    lateinit var btnGoToFragment2: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_fragment1, container, false)

        btnGoToFragment2 = v.findViewById(R.id.btn_go_to_fragment2)
        // Inflate the layout for this fragment
        return v
    }




    override fun onStart() {
        super.onStart()

        btnGoToFragment2.setOnClickListener {

            val action2 = Fragment1Directions.actionFragment1ToFragment2()
            v.findNavController().navigate(action2)

        }
    }
}
