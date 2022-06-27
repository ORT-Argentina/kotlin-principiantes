package ar.edu.ort.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ar.edu.ort.myapplication.R
import ar.edu.ort.myapplication.activities.SecondaryActivity

class LoginFragment : Fragment() {

    lateinit var vista: View
    lateinit var btnLoginAuth: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login, container, false)

        btnLoginAuth = vista.findViewById(R.id.btnLoginAuth)

        return vista
    }

    override fun onStart() {
        super.onStart()

        btnLoginAuth.setOnClickListener{
            var intentNav = Intent( activity, SecondaryActivity::class.java  )
            startActivity(intentNav)
            activity?.finish()
        }

    }
}