package ort.edu.ar.navigation5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MainActivity", "onCreate");
    }

    override fun onStart() {
        super.onStart()
        Log.v("MainActivity", "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.v("MainActivity", "onResume");
    }


}