package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.ItemMusicTravelModel
import com.example.myapplication.domain.repositories.MusicTravelRepository

class GetMusicTravelsUseCase(private val repository: MusicTravelRepository) {
    suspend fun get(): List<ItemMusicTravelModel> {
        val res = mutableListOf<ItemMusicTravelModel>()
        for (item in repository.getAll()) {
            item.price = "от ${item.price.addSpaceToPrice()} ₽"
            res.add(item)
        }

        return res
    }

    private fun String.addSpaceToPrice() = buildString {
        var counterInterval = 0
        for (c in this@addSpaceToPrice.reversed()) {
            if (counterInterval == 3) {
                append(' ')
                counterInterval = 0
            }

            append(c)
            counterInterval++
        }
        reverse()
    }

}