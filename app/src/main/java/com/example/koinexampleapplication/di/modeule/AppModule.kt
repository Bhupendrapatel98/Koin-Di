package com.example.koinexampleapplication.di.modeule


import com.example.koinexampleapplication.data.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appmodule = module {

    single { providesBaseUrl() }

    single { provideRetrofit(get()) }

    single { provideApiService(get()) }
}

fun providesBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

private fun provideRetrofit(BASE_URL: String): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)