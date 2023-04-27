package ar.edu.ort.tp3.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista =  inflater.inflate(R.layout.fragment_second, container, false)
        val alumno = SecondFragmentArgs.fromBundle(requireArguments()).unAlumno

        val txtSecondFragmentMain = vista.findViewById<TextView>(R.id.txtSecondFragmentMain)

        txtSecondFragmentMain.text = alumno.nombre

        vista.findViewById<Button>(R.id.btnSecondFragmentBack).setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            this.findNavController().navigate(action)
        }



        return vista;
    }
}