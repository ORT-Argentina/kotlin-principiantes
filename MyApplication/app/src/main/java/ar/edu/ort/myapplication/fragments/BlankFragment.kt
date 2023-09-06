package ar.edu.ort.myapplication.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ar.edu.ort.myapplication.R
import com.google.android.material.snackbar.Snackbar

class BlankFragment : Fragment() {

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_blank, container, false)
        return v;
    }

    override fun onStart() {
        super.onStart()

        v.findViewById<Button>(R.id.button)


        v.setOnClickListener {
            Snackbar.make(it, "Hello World", Snackbar.LENGTH_LONG).show()
        }

    }


}