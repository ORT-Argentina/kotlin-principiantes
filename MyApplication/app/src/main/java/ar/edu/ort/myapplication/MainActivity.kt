package ar.edu.ort.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var btnDashboard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn2 = findViewById<Button>(R.id.button2)

        btn2.setOnClickListener {
            Snackbar.make(it, "Hello World", Snackbar.LENGTH_LONG).show()
        }

    }

}