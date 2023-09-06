package ar.edu.ort.myapplication.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import ar.edu.ort.myapplication.MainActivity
import ar.edu.ort.myapplication.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLoginRegister = findViewById<Button>(R.id.btnLoginRegister)



        btnLoginRegister.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
            //val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}