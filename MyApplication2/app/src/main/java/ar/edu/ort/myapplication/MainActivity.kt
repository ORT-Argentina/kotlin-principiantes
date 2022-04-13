package ar.edu.ort.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()

        submit = findViewById(R.id.btnSubmit)

        submit.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
    }
}