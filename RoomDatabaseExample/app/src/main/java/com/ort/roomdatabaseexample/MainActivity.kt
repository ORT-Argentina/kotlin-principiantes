package com.ort.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ort.roomdatabaseexample.database.appDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
