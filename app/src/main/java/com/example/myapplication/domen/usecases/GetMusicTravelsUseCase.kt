package com.example.myapplication.domen.usecases

import com.example.myapplication.domen.models.ItemMusicTravelModel
import com.example.myapplication.domen.repositories.MusicTravelRepository

class GetMusicTravelsUseCase(private val repository: MusicTravelRepository) {
    suspend fun execute(): List<ItemMusicTravelModel> {
        return repository.getAll()
    }



}