package ar.edu.ort.myapplication

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var submit: Button
    lateinit var txtEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()

        submit = findViewById(R.id.btnSubmit)

        txtEmail = findViewById(R.id.txtEmail)

        submit.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }

        txtEmail.setText("test")
    }
}