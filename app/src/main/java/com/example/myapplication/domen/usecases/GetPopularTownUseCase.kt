package com.example.myapplication.domen.usecases

import com.example.myapplication.domen.models.PopularTownModel
import com.example.myapplication.domen.repositories.PopularTownRepository

class GetPopularTownUseCase(private val repository: PopularTownRepository) {
    suspend fun get(): List<PopularTownModel> {
        return repository.getByLimit(3)
    }
}
