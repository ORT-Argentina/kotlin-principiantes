package ar.edu.ort.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import ar.edu.ort.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondaryActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var buttonBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        setTitle("Home")


        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        buttonBar = findViewById(R.id.bottom_bar)

        NavigationUI.setupWithNavController(buttonBar, navHostFragment.navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.secondary_menu, menu)
        return true
    }


}