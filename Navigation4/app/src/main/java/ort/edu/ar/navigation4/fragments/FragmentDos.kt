package ort.edu.ar.navigation4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import ort.edu.ar.navigation4.R


class FragmentDos : Fragment() {

    lateinit var v: View
    lateinit var b: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dos, container, false)

        b = v.findViewById(R.id.btnFragment2Nav)

        b.setOnClickListener {
            //val action = FragmentDosDirections.actionFragment2ToFragment1()
            v.findNavController().navigateUp()
        }



        return v;
    }

    override fun onStart() {
        super.onStart()

        val unCliente = FragmentDosArgs.fromBundle(requireArguments()).uncliente


        b.setText(Parametros.dato)

    }


}