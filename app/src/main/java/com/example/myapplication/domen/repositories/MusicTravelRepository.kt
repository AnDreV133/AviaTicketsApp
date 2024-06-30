package com.example.myapplication.domen.repositories

import com.example.myapplication.domen.models.ItemMusicTravelModel
import com.example.myapplication.repositories.models.Offer

interface MusicTravelRepository {
    suspend fun getAll(): List<ItemMusicTravelModel>
}