package ar.edu.ort.myapplication.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.Guideline
import androidx.navigation.findNavController
import ar.edu.ort.myapplication.R

class SplashFragment : Fragment() {

    lateinit var vista: View
    lateinit var btnSplashMain: Button
    lateinit var guideLineSplash: Guideline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_splash, container, false)

        btnSplashMain = vista.findViewById(R.id.btnSplashMain)

        guideLineSplash = vista.findViewById(R.id.glTopSplash)

        return vista
    }

    override fun onStart() {
        super.onStart()

        btnSplashMain.setOnClickListener{
            val action1 = SplashFragmentDirections.actionSplashFragmentToLoginFragment3()
            vista.findNavController().navigate(action1)
        }

    }

}