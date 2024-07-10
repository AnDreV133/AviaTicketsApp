package com.example.myapplication.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OffersApi {
    private const val BASE_URL = "https://run.mocky.io/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(OffersApiQueryManager::class.java)

    suspend fun getOffers() = api.getOffers()
}