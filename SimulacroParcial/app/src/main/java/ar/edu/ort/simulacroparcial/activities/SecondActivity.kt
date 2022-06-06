package ar.edu.ort.simulacroparcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import ar.edu.ort.simulacroparcial.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onStart() {
        super.onStart()

        Handler().postDelayed({
            val indention = Intent(this, MainActivity::class.java)
            startActivity(indention)
        }, 4000)

    }
}