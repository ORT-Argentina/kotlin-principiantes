package com.example.splashscreenv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.splashscreenv2.R


class SecondFragment : Fragment() {

    lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_second, container, false)

        val btnSecondFragmentBack = vista.findViewById<Button>(R.id.btnSecondFragmentBack)


        val alumno = SecondFragmentArgs.fromBundle(requireArguments()).unAlumno
        val txtSecondFragView = vista.findViewById<TextView>(R.id.txtSecondFragView)
        txtSecondFragView.text = alumno.nombre

        btnSecondFragmentBack.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            vista.findNavController().navigate(action)
        }

        return vista;
    }
}