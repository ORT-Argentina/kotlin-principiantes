package ar.edu.ort.simulacroparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import ar.edu.ort.simulacroparcial.R
import com.google.android.material.snackbar.Snackbar


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    lateinit var v: View
    lateinit var btnNavFrag1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_1, container, false)

        btnNavFrag1 = v.findViewById(R.id.btnNavFrag1)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnNavFrag1.setOnClickListener {

            Snackbar.make(v, "On Click del Boton", Snackbar.LENGTH_SHORT).show()

            val action = Fragment1Directions.actionFragment1ToFragment2()
            v.findNavController().navigate(action)

            /*val fragment = Fragment2()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()*/
        }
    }


}