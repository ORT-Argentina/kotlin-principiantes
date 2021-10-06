package com.manadigital.userinterface1

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    lateinit var txtLabel : TextView
    lateinit var btnChangeText : Button

    //lateinit var swMain : Switch

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLabel = findViewById(R.id.txtLabel)                 //Referencia de vistas al xml
        btnChangeText = findViewById(R.id.btnPrimary)

        txtLabel.setText("Texto Dinamico")

        btnChangeText.setOnClickListener {
            txtLabel.setText("Texto Modificado por Click")
            
            val release = Build.VERSION.RELEASE
            val sdkVersion = Build.VERSION.SDK_INT

            if( sdkVersion >= 29 ) {
                val parentLayout: View = findViewById(android.R.id.content)
                val snackbar = Snackbar.make(parentLayout, "Mensaje", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }else{
                Toast.makeText(this, "Mensaje", Toast.LENGTH_SHORT).show();
            }
        }

        /*
        //swMain = findViewById(R.id.swMain)

        btnChangeText.setOnClickListener {
            txtLabel.text = "texto cambiado"

        }*/

       /* swMain.setOnCheckedChangeListener { buttonView, isChecked ->
            val release = Build.VERSION.RELEASE
            val sdkVersion = Build.VERSION.SDK_INT

            if( sdkVersion >= 29 ) {
                val parentLayout: View = findViewById(android.R.id.content)
                val snackbar = Snackbar.make(parentLayout, isChecked.toString(), Snackbar.LENGTH_SHORT)
                snackbar.show()
            }else{
                Toast.makeText(this, sdkVersion.toString(), Toast.LENGTH_SHORT).show();
            }
        }*/

    }
}
