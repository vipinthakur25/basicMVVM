package com.example.basicmvvmapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: RemoteApiService by lazy {
        retrofit.create(RemoteApiService::class.java)
    }
}