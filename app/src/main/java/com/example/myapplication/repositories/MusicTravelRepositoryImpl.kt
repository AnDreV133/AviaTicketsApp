package com.example.myapplication.repositories

import android.content.Context
import android.graphics.BitmapFactory
import com.example.myapplication.R
import com.example.myapplication.domen.models.ItemMusicTravelModel
import com.example.myapplication.domen.repositories.MusicTravelRepository
import com.example.myapplication.repositories.api.OffersApi

class MusicTravelRepositoryImpl(private val context: Context) : BaseRepository(), MusicTravelRepository {
    override suspend fun getAll(): List<ItemMusicTravelModel> {
        // todo stub
        return listOf(
            ItemMusicTravelModel(
                image = BitmapFactory.decodeResource(context.resources, R.drawable.img_offer_1_stub),
                title = "Die Antwoord",
                town = "Будапешт",
                price = "5000"
            ),

            ItemMusicTravelModel(
                image = BitmapFactory.decodeResource(context.resources, R.drawable.img_offer_2_stub),
                title = "Socrat&Lera",
                town = "Санкт-Петербург",
                price = "1999"
            ),

            ItemMusicTravelModel(
                image = BitmapFactory.decodeResource(context.resources, R.drawable.img_offer_3_stub),
                title = "Лампабикт",
                town = "Москва",
                price = "2390"
            )
        )

        val data = getDataFromRequest { OffersApi.getOffers() } ?: return emptyList()

        // todo stub
        val stubImages = listOf(
            BitmapFactory.decodeFile("drawable/img_offer_1_stub.png"),
            BitmapFactory.decodeFile("drawable/img_offer_2_stub.png"),
            BitmapFactory.decodeFile("drawable/img_offer_3_stub.png")
        )

        val res = mutableListOf<ItemMusicTravelModel>()
        for (i in 0..3) {
            res.add(
                ItemMusicTravelModel(
                    stubImages[i],
                    data.offers[i].title,
                    data.offers[i].town,
                    data.offers[i].price.value.toString()
                )
            )
        }

        return res
    }
}


