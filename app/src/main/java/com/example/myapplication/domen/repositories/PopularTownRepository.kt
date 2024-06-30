package com.example.myapplication.domen.repositories

import com.example.myapplication.domen.models.PopularTownModel

interface PopularTownRepository {
    suspend fun getByLimit(limit: Int): List<PopularTownModel>
}
