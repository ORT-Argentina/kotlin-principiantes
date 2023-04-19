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
    lateinit var fragment2: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragment2 = inflater.inflate(R.layout.fragment_fragment2, container, false)

        btnReturn = fragment2.findViewById(R.id.btnNavFrag2Frag1)
        title = fragment2.findViewById(R.id.txt_label_fragment2)

        return fragment2
    }

    override fun onStart() {
        super.onStart()

        //val lamismacosa = Fragment2Args.fromBundle(requireArguments()).uncosa

        //title.text = lamismacosa.untexto

        val action = Fragment2Directions.actionFragment2ToFragment1()

        btnReturn.setOnClickListener {

            fragment2.findNavController().navigate(action)

        }
    }


}
