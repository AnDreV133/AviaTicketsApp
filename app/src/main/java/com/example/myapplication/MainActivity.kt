package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG onCreate")
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragment_container)
        val menuBar = AppBarConfiguration(
            setOf(
                R.id.nav_menu_item_avia_tickets,
                R.id.nav_menu_item_hotels,
                R.id.nav_menu_item_brief,
                R.id.nav_menu_item_subscriptions,
                R.id.nav_menu_item_profile
            )
        )

        setupActionBarWithNavController(navController, menuBar)
        findViewById<BottomNavigationView>(R.id.main_menu_bar).setupWithNavController(navController)
    }
}