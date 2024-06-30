package com.example.basicmvvmapp.network

import com.example.basicmvvmapp.model.UserResponse
import com.example.basicmvvmapp.model.UserResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApiService {

    @GET("/users")
    suspend fun getUser(): Response<List<UserResponseItem>>
}