package ar.edu.ort.tp3.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_first, container, false)

        vista.findViewById<Button>(R.id.btnFirstFragmentGo).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            this.findNavController().navigate(action)
        }

        return vista
    }
}