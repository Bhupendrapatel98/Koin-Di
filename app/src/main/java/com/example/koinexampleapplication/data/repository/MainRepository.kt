package com.example.koinexampleapplication.data.repository

import com.example.koinexampleapplication.data.api.ApiService

class MainRepository(private val apiService: ApiService) {
    suspend fun getUsers() =  apiService.getUsers()
}