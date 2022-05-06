package com.adb.navigationdrawerexample.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.adb.navigationdrawerexample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Busco el Control de Navegación
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        //Asigno al Menu Drawer el control de navegación para que me permita hacer la navegación
        nav_view.setupWithNavController(navController)

        //nav_view.setupWithNavController(navController)
        //NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout_id)

//        //Resolución del Challenge
//
//        //Creo una configuración para Toolbar
        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(),
            /*topLevelDestinationIds = setOf(
                R.id.fragment1,
                R.id.fragment2,
                R.id.fragment3
            ),*/
            fallbackOnNavigateUpListener = ::onSupportNavigateUp

        )
//
//        //Seteo la configuración
        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        //Dejo un lisener para cuando se produce el cambio de destino unicamente me reemplace el icono.
        navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer_layout_id)
    }*/

    override fun onSupportNavigateUp(): Boolean {
        //Fuezo al boton de navegación de la toolbar que solo abra el menú Drawer
        if (drawer_layout_id.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_id.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout_id.openDrawer(GravityCompat.START)
        }

        //Cancelo la navegación
        //return NavigationUI.navigateUp(navController, drawer_layout_id)
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawe_menu, menu)
        return true
    }
}