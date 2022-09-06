package com.ort.edu.interfaceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        Hay 3 layouts creados para este activity:
        - activity_main.xml: Lo que llegamos a hacer en clase con ConstraintLayout
        - activity_main2.xml: Usa ConstraintLayout y guidelines para tener una UI 100% responsive
                              Ademas, se muestra el uso del archivo dimens.xml para los valores que quedaron constantes
        - activity_main3.xml: Usa LinearLayout, conveniente en este caso al ser una pantalla simple.

        Para probar cada uno solo deberiamos modificar el setContentView() para que reciba el layout que queramos ver.
        Ej:
        - setContentView(R.layout.activity_main)
        - setContentView(R.layout.activity_main2)
        - setContentView(R.layout.activity_main3)
         */

        setContentView(R.layout.activity_main)
    }
}