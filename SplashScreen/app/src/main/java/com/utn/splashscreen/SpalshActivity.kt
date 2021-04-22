package com.utn.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.coroutines.delay

class SpalshActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)


        Handler().postDelayed(

            {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            , SPLASH_TIME_OUT)
    }
}
