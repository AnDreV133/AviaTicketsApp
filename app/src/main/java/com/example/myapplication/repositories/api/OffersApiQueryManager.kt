package com.example.myapplication.repositories.api

import com.example.myapplication.repositories.models.Offers
import retrofit2.Response
import retrofit2.http.GET

interface OffersApiQueryManager {
    @GET("./")
    suspend fun getOffers(): Response<Offers>

}