package com.manadigital.userinterface1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtLabel : TextView
    lateinit var btnChangeText : Button
    lateinit var swMain : Switch

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLabel = findViewById(R.id.txt_label)                 //Referencia de vistas al xml
        btnChangeText = findViewById(R.id.btn_change_text)
        swMain = findViewById(R.id.swMain)

        btnChangeText.setOnClickListener {
            txtLabel.text = "texto cambiado"
            
        }

        swMain.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this, isChecked.toString(),Toast.LENGTH_SHORT).show();
        }

    }
}
