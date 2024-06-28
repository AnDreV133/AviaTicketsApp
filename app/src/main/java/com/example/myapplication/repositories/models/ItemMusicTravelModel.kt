package com.example.myapplication.repositories.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Offers(
    @SerializedName("offers") val offers: List<Offer>
) : Serializable
data class Offer(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("town") val town: String,
    @SerializedName("price") val price: Price
) : Serializable

data class Price(
    @SerializedName("value") val value: Int
) : Serializable
