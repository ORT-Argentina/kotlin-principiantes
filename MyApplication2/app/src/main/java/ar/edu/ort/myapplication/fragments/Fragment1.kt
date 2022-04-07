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


class Fragment1 : Fragment() {

    lateinit var frag1: View
    lateinit var btnNav1: Button
    lateinit var btnNav2: Button
    lateinit var txtTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frag1 = inflater.inflate(R.layout.fragment_1, container, false)

        btnNav1 = frag1.findViewById(R.id.btnNavFrag2)
        btnNav2 = frag1.findViewById(R.id.btnNavFrag3)
        txtTitle = frag1.findViewById(R.id.textView)

        return frag1
    }

    override fun onStart() {
        super.onStart()

        txtTitle.text = this.id.toString()

        btnNav1.setOnClickListener{
            val action = Fragment1Directions.actionFragment1ToFragment2()
            frag1.findNavController().navigate(action)
        }

        btnNav2.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment3()
            frag1.findNavController().navigate(action)
        }
    }
}