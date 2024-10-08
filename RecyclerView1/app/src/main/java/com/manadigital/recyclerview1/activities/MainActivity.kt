package com.manadigital.recyclerview1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.manadigital.recyclerview1.R

class MainActivity : AppCompatActivity() {

    lateinit var test:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        test = findViewById(R.id.ActivityMainBtnMain)

        test.setOnClickListener(){
            Snackbar.make(it, "Hola 1", Snackbar.LENGTH_SHORT).show()
        }
        Log.d("MainActivity", "onCreate")
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
