package ort.edu.ar.navigation4.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import ort.edu.ar.navigation4.R
import ort.edu.ar.navigation4.entidades.Cliente

class Fragment1 : Fragment() {

    lateinit var v: View

    companion object {
        fun newInstance() = Fragment1()
    }

    private lateinit var viewModel: Fragment1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment1, container, false)

        return v;
    }

    override fun onStart() {
        super.onStart()
        val btnNav = v.findViewById<Button>(R.id.btnFragment1Nav)
        btnNav.setOnClickListener {
            val clientKtn = Cliente("Martin", 40)

            Parametros.dato = "Hola"

            val action = Fragment1Directions.actionFragment1ToFragmentDos(clientKtn)
            v.findNavController().navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}