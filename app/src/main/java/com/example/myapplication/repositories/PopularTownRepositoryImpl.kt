package com.example.myapplication.repositories

import android.content.Context
import android.graphics.BitmapFactory
import com.example.myapplication.R
import com.example.myapplication.domain.models.PopularTownModel
import com.example.myapplication.domain.repositories.PopularTownRepository

class PopularTownRepositoryImpl(private val context: Context) : PopularTownRepository {
    override suspend fun getByLimit(limit: Int): List<PopularTownModel> {
        return listOf(
            PopularTownModel(
                BitmapFactory.decodeResource(context.resources, R.drawable.img_popular_town_1_stub),
                "Стамбул"
            ),
            PopularTownModel(
                BitmapFactory.decodeResource(context.resources, R.drawable.img_popular_town_2_stub),
                "Сочи"
            ),
            PopularTownModel(
                BitmapFactory.decodeResource(context.resources, R.drawable.img_popular_town_3_stub),
                "Пхукет"
            )
        ).subList(0, limit)
    }
}