package com.example.myapplication.app

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.domain.utils.TAG
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $this")
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragment_container)

        findViewById<BottomNavigationView>(R.id.main_menu_bar).setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart $this")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume $this")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause $this")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop $this")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState $this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy $this")
    }
}