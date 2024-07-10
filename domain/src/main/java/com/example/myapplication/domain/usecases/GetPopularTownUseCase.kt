package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.PopularTownModel
import com.example.myapplication.domain.repositories.PopularTownRepository

class GetPopularTownUseCase(private val repository: PopularTownRepository) {
    suspend fun get(): List<PopularTownModel> {
        return repository.getByLimit(3)
    }
}
