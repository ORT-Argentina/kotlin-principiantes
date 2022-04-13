package ar.edu.ort.navigation3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import ar.edu.ort.navigation3.R


/**
 * A simple [Fragment] subclass.
 * Use the [Fragmento1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragmento1 : Fragment() {

    lateinit var vista: View
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var txtLogin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_1, container, false)

        btn1 = vista.findViewById(R.id.btnNavFrag2)
        btn2 = vista.findViewById(R.id.btnNavFrag3)
        txtLogin = vista.findViewById(R.id.txtUsername)

        return vista
    }

    override fun onStart() {
        super.onStart()

        activity?.title = "Fragmento1"

       btn1.setOnClickListener {
           val action = Fragmento1Directions.actionFragment1ToFragmento2()
           vista.findNavController().navigate(action)
       }

        btn2.setOnClickListener {
            val action = Fragmento1Directions.actionFragment1ToFragmento3()
            vista.findNavController().navigate(action)
        }
    }


}