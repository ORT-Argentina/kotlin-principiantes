package ar.edu.ort.simulacroparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import ar.edu.ort.simulacroparcial.R


class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var btnNavFrag2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_2, container, false)

        btnNavFrag2 = v.findViewById(R.id.btnNavFrag2)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnNavFrag2.setOnClickListener {
           val action = Fragment2Directions.actionFragment2ToFragment1()
            v.findNavController().navigate(action)
        }
    }
}