package com.example.basicmvvmapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicmvvmapp.model.UserResponse
import com.example.basicmvvmapp.model.UserResponseItem
import com.example.basicmvvmapp.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository) : ViewModel() {
    val users: LiveData<List<UserResponseItem>> get() = userRepository.users

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUsers()
        }
    }
}