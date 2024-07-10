package com.example.myapplication.data.api

import com.example.myapplication.data.models.Offers
import retrofit2.Response
import retrofit2.http.GET

interface OffersApiQueryManager {
    @GET("./")
    suspend fun getOffers(): Response<Offers>

}