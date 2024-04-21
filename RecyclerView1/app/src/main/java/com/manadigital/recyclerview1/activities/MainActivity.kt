package com.manadigital.recyclerview1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.fragments.DestinationFragment
import com.manadigital.recyclerview1.fragments.listFragment
import com.manadigital.recyclerview1.fragments.listFragmentDirections

class MainActivity : AppCompatActivity() {

    lateinit var test:Button;
    lateinit var navigateButton:FloatingActionButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        test = findViewById(R.id.ActivityMainBtnMain)

        test.setOnClickListener(){
            Snackbar.make(it, "Hola 1", Snackbar.LENGTH_SHORT).show()
        }
        Log.d("MainActivity", "onCreate")

        navigateButton = findViewById(R.id.ActivityMainFABNavigate)

        navigateButton.setOnClickListener(){
            // pasarle la action de navegacion de un lado hacia otro, para poder apilar
            // findNavController(R.id.fragment).navigate(R.id.action_listFragment_to_destinationFragment);
            // ListFragment().findNavController().navigate()

            val action = listFragmentDirections.actionListFragmentToDestinationFragment()
            this.findNavController(R.id.fragment).navigate(action)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")

        test.setOnClickListener(){
            Snackbar.make(it, "Hola 2", Snackbar.LENGTH_SHORT).show()
        }


    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }
}
