package com.example.growigh

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("images")
    fun getImages(): Call<List<FeedItem>>
}
