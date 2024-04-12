package com.manadigital.navigation1.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

import com.manadigital.navigation1.R

/**
 * A simple [Fragment] subclass.
 */
class Fragment2 : Fragment() {

    lateinit var btnReturn: Button
    lateinit var title: TextView
    lateinit var view1: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_fragment2, container, false)

        btnReturn = view1.findViewById(R.id.btnNavFrag2Frag1)
        title = view1.findViewById(R.id.txt_label_fragment2)

        return view1
    }

    override fun onStart() {
        super.onStart()

        val parametros = Fragment2Args.fromBundle(requireArguments())

        title.text = parametros.unContacto.nombre

        val action = Fragment2Directions.actionFragment2ToFragment1()

        btnReturn.setOnClickListener {

            view1.findNavController().navigate(action)

        }
    }


}
