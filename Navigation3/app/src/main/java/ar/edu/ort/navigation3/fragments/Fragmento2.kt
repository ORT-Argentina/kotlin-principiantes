package ar.edu.ort.navigation3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import ar.edu.ort.navigation3.R



class Fragmento2 : Fragment() {

    lateinit var vista: View
    lateinit var btn1: Button
    lateinit var txtView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragmento2, container, false)

        btn1 = vista.findViewById(R.id.btnNavFrag1)
        txtView = vista.findViewById(R.id.txtViewLogin3)

        return vista
    }

    override fun onStart() {
        super.onStart()

        activity?.title = "Fragmento2"

        btn1.setOnClickListener {
            val action = Fragmento2Directions.actionFragmento2ToFragment1()
            vista.findNavController().navigate(action)
        }
    }

}