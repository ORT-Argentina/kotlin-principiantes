package com.ort.edu.challengepractica

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigationView()
    }

    /**
     * Configuro la barra inferior de navegación
     */
    private fun setupBottomNavigationView() {
        // Busco los componentes en la View generada por su id
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        // Relaciono mi Bottom Nav View con mi nav graph
        bottomNavView.setupWithNavController(navHostFragment.navController)

        // Agrego un listener para poder escuchar cada vez que se realiza una navegacion
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, arguments ->

            // Si mi destino es el login entonces oculto la barra inferior. Caso contrario la muestro

            if (destination.id == R.id.loginFragment) {
                bottomNavView.visibility = View.GONE
            } else {
                bottomNavView.visibility = View.VISIBLE

                // Si mi destino es la Home, tomo el userName que recibio por parametro y lo almaceno en un Object
                if (destination.id == R.id.homeFragment) {
                    arguments?.getString("username")?.let { UserSession.userName = it }
                }
            }
        }
    }
}