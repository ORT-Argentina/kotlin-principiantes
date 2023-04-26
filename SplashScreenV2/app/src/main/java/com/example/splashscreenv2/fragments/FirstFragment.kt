package com.example.splashscreenv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.splashscreenv2.R
import com.example.splashscreenv2.entities.Alumno

class FirstFragment : Fragment() {

     lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




        vista = inflater.inflate(R.layout.fragment_first, container, false)

        val btnFragment1Nav = vista.findViewById<Button>(R.id.btnFragment1Nav)


        btnFragment1Nav.setOnClickListener {

            var alumno = Alumno("Juan", 30, Alumno.Constants.cursoA);


            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(alumno)
            vista.findNavController().navigate(action)
        }

        return vista;
    }

}