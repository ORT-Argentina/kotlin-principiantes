package ort.edu.ar.navigation5.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import ort.edu.ar.navigation5.R
import ort.edu.ar.navigation5.models.Numero
import ort.edu.ar.navigation5.statics.Numeros

class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var el_parametro: Numero

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //el_parametro = Fragment2Args.fromBundle(requireArguments()).unNumero

        el_parametro = Numero(Numeros.origen, Numeros.destino)

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_2, container, false)
        val b = v.findViewById<Button>(R.id.btnFragment2Nav)

        b.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment3(el_parametro)
            v.findNavController().navigate(action)
        }
        return v
    }

    override fun onStart() {
        super.onStart()

        val tv = v.findViewById<TextView>(R.id.tvFragment2Title)

        tv.setText(el_parametro.origen.toString() + el_parametro.destino.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment2", "onCreate")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment2", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment2", "onDestroy")
    }

}