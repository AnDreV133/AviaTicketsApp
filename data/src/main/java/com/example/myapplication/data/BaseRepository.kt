package com.example.myapplication.data

import retrofit2.Response

abstract class BaseRepository {
    protected suspend fun <T> getDataFromRequest(
        request: suspend () -> Response<T>
    ): T? {
        val response = request()
        return if (response.isSuccessful) response.body() else null
    }
}