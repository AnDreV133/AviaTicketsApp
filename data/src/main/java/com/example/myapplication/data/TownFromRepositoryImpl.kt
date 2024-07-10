package com.example.myapplication.data

import android.content.Context
import com.example.myapplication.domain.repositories.TownFromRepository

class TownFromRepositoryImpl(context: Context) :
    TownFromRepository {
    private val sp = context.getSharedPreferences("TownFrom", Context.MODE_PRIVATE)

    override fun getTown(): String {
        return sp.getString("town", "") ?: ""
    }

    override fun setTown(town: String) {
        sp.edit().putString("town", town).apply()
    }

}