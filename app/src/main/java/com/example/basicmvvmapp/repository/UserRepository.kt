package com.example.basicmvvmapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basicmvvmapp.model.UserResponseItem
import com.example.basicmvvmapp.network.RemoteApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository(val service: RemoteApiService) {

    private val usersLiveData = MutableLiveData<List<UserResponseItem>>()
    val users: LiveData<List<UserResponseItem>> get() = usersLiveData

    suspend fun getUsers() {
        val result = service.getUser()
        if (result.body() != null) {
            usersLiveData.postValue(result.body())
        }
    }
}
