package com.example.koinexampleapplication.data.api

import com.example.koinexampleapplication.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUsers(): Response<List<User>>
}