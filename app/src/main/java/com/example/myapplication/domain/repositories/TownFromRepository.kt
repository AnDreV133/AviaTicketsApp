package com.example.myapplication.domain.repositories

interface TownFromRepository {
    fun getTown(): String
    fun setTown(town: String)
}