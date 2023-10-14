package ort.edu.ar.navigation5.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import ort.edu.ar.navigation5.viewmodel.Fragment3ViewModel
import ort.edu.ar.navigation5.R

class Fragment3 : Fragment() {

    companion object {
        fun newInstance() = Fragment3()
    }

    private lateinit var viewModel: Fragment3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_fragment3, container, false)
        val b = v.findViewById<Button>(R.id.btnFragment3Nav)

        val elnumero = Fragment3Args.fromBundle(requireArguments()).elMismoNumero

        Log.d("Fragment3", elnumero.origen.toString() + elnumero.destino.toString())


        b.setOnClickListener {
            v.findNavController().navigateUp()
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment3ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment3", "onCreate")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment3", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment3", "onDestroy")
    }

}