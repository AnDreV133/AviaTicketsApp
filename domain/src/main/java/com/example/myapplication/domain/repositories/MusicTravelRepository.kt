package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.ItemMusicTravelModel

interface MusicTravelRepository {
    suspend fun getAll(): List<ItemMusicTravelModel>
}