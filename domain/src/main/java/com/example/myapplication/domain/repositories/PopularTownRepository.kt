package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.PopularTownModel

interface PopularTownRepository {
    suspend fun getByLimit(limit: Int): List<PopularTownModel>
}
