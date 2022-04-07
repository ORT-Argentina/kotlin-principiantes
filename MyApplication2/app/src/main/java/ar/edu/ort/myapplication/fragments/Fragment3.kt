package ar.edu.ort.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import ar.edu.ort.myapplication.R

class Fragment3 : Fragment() {

    lateinit var fragment: View
    lateinit var btnNav1: Button
    lateinit var titMain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragment =  inflater.inflate(R.layout.fragment_3, container, false)

        btnNav1 = fragment.findViewById(R.id.btnNavFrag)

        titMain = fragment.findViewById(R.id.txtTitle3)

        return fragment
    }

    override fun onStart() {
        super.onStart()

        titMain.text = this.id.toString()

        btnNav1.setOnClickListener {
            val action = Fragment3Directions.actionFragment3ToFragment1()
            fragment.findNavController().navigate(action)
        }
    }
}