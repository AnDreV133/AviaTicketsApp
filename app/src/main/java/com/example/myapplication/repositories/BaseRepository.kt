package com.example.myapplication.repositories

import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class BaseRepository {

    /**
     * Do network request
     *
     * @param doSomethingInSuccess for working when request result is success
     * @return request result in [flow] with [Either]
     */
    protected suspend fun <T> getDataFromRequest(
        request: suspend () -> Response<T>
    ): T? {
        val response = request()
        return if (response.isSuccessful) response.body() else null
    }
}