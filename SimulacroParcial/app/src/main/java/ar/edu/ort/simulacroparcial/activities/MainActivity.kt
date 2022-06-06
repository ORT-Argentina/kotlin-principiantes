package ar.edu.ort.simulacroparcial.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.simulacroparcial.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)

        //Busco el Controlador de Navegacion
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

    }
}