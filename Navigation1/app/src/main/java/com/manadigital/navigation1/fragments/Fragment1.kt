package com.manadigital.navigation1.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.manadigital.navigation1.Entities.Cosa

import com.manadigital.navigation1.R

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    lateinit var view1: View
    lateinit var btnGoToFragment2: Button
    lateinit var txtInput: EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //inflater.inflate(R.layout.fragment_fragment1, container, false)

        view1 = inflater.inflate(R.layout.fragment_fragment1, container, false)

        btnGoToFragment2 = view1.findViewById(R.id.btn_go_to_fragment2)

        btnGoToFragment2.setOnClickListener{

            val action2 = Fragment1Directions.actionFragment1ToFragment2()
            view1.findNavController().navigate(action2)
        }

        txtInput = view1.findViewById(R.id.txtInput)



        // Inflate the layout for this fragment
        return view1
    }




    override fun onStart() {
        super.onStart()


        requireActivity().title = "Prueba"

        /*btnGoToFragment2.setOnClickListener {

            //val objeto1 = Cosa(txtInput.text.toString())

            val action2 = Fragment1Directions.actionFragment1ToFragment2()
            view1.findNavController().navigate(action2)

        }*/
    }
}
