package com.adb.navigationdrawerexample.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.adb.navigationdrawerexample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        nav_view.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout_id)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer_layout_id)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawe_menu, menu)
        return true
    }

    /*override fun onBackPressed() {
        if (drawer_layout_id.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_id.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }*/
}