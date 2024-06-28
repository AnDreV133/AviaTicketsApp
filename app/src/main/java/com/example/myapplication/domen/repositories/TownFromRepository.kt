package com.example.myapplication.domen.repositories

interface TownFromRepository {
    fun getTown(): String
    fun setTown(town: String)
}