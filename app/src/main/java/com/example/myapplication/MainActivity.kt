package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = findNavController(R.id.nav_fragment_container)
        val menu = AppBarConfiguration(
            setOf(
                R.id.nav_menu_item_avia_tickets,
                R.id.nav_menu_item_hotels,
                R.id.nav_menu_item_brief,
                R.id.nav_menu_item_subscriptions,
                R.id.nav_menu_item_profile
            )
        )

        setupActionBarWithNavController(container, menu)
    }
}