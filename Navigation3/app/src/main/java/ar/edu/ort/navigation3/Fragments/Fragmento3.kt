package ar.edu.ort.navigation3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import ar.edu.ort.navigation3.R

class Fragmento3 : Fragment() {

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
        vista = inflater.inflate(R.layout.fragmento3, container, false)

        btn1 = vista.findViewById(R.id.btnNavFrag1Alt)
        txtView = vista.findViewById(R.id.txtViewLogin2)

        return vista
    }

    override fun onStart() {
        super.onStart()

        activity?.title = "Fragmento3"

        val dato = Fragmento3Args.fromBundle(requireArguments()).dato
        txtView.text = dato.undato

        btn1.setOnClickListener {
            val action = Fragmento3Directions.actionFragmento3ToFragment1()
            vista.findNavController().navigate(action)
        }
    }

}