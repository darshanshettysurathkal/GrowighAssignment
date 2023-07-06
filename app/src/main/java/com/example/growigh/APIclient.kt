package com.example.growigh

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIclient {
    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getApiService(): ApiService
        {
            return retrofit.create(ApiService::class.java)
        }
    }
}
