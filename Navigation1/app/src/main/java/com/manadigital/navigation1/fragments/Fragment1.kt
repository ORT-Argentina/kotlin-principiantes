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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.navigation1.Entities.Contacto

import com.manadigital.navigation1.R
import com.manadigital.navigation1.adapters.ContactAdapter

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    lateinit var view1: View
    lateinit var btnGoToFragment2: Button
    lateinit var txtInput: EditText
    lateinit var recContactos: RecyclerView

    private var contactos : MutableList<Contacto> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        view1 = inflater.inflate(R.layout.fragment_fragment1, container, false)

        btnGoToFragment2 = view1.findViewById(R.id.btn_go_to_fragment2)

        recContactos = view1.findViewById(R.id.rec_contactos)

        btnGoToFragment2.setOnClickListener{

            //val action2 = Fragment1Directions.actionFragment1ToFragment2(contact)
            view1.findNavController().navigate(action2)
        }

        txtInput = view1.findViewById(R.id.txtInput)

        // Inflate the layout for this fragment
        return view1
    }




    override fun onStart() {
        super.onStart()

        for(i in 1..2) {
            contactos.add(
                Contacto(
                    "Juan",
                    "123456789",
                    "juan@hotmail.com",
                    "",
                    "https://www.google.com"
                )
            )
            contactos.add(
                Contacto(
                    "Martin",
                    "asdasd",
                    "martin@hotmail.com",
                    null,
                    "https://www.google.com"
                )
            )
        }

        requireActivity().title = "Prueba"


        recContactos.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val contactAdapter = ContactAdapter(contactos)

        recContactos.layoutManager = linearLayoutManager
        recContactos.adapter = contactAdapter



        /*btnGoToFragment2.setOnClickListener {

            //val objeto1 = Cosa(txtInput.text.toString())

            val action2 = Fragment1Directions.actionFragment1ToFragment2()
            view1.findNavController().navigate(action2)

        }*/
    }
}
