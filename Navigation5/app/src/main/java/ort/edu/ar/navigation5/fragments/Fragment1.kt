package ort.edu.ar.navigation5.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import ort.edu.ar.navigation5.R
import ort.edu.ar.navigation5.models.Numero
import ort.edu.ar.navigation5.statics.Numeros


class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_1, container, false)

        val b = v.findViewById<Button>(R.id.btnFragment1Nav)




        b.setOnClickListener {

            val o = v.findViewById<EditText>(R.id.txtFrag1Origen).text.toString();
            val d = v.findViewById<EditText>(R.id.txtFrag1Destino).text.toString();

            Numeros.origen = o.toInt()
            Numeros.destino = d.toInt()

            val unNumero = Numero(o.toInt(),d.toInt())
            val action = Fragment1Directions.actionFragment1ToFragment2(unNumero)
            v.findNavController().navigate(action)
        }


        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment1", "onCreate")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment1", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment1", "onDestroy")
    }
}