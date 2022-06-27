package ar.edu.ort.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import ar.edu.ort.myapplication.R

class MainActivity : AppCompatActivity() {

    lateinit var fcvMain: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fcvMain = findViewById(R.id.fcvMain)

    }
}