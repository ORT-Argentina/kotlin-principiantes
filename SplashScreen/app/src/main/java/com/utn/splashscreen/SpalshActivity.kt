package com.utn.splashscreen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import kotlinx.coroutines.delay

class SpalshActivity : AppCompatActivity() {

    lateinit var btnInicio : Button

    companion object {
        private const val SPLASH_TIME_OUT:Long = 3000 // 3 seconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)


        btnInicio = findViewById(R.id.btnInicio)

        btnInicio.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:911")))
        }


        Handler().postDelayed(
            {
                /*startActivity(Intent(this,MainActivity::class.java))
                finish()*/
            }
            , SPLASH_TIME_OUT)
    }
}
