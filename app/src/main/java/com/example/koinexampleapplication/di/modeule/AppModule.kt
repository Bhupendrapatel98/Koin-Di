package com.example.koinexampleapplication.di.modeule


import android.content.Context
import com.example.koinexampleapplication.data.api.ApiService
import com.example.koinexampleapplication.utills.NetworkHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appmodule = module {

    single { providesBaseUrl() }

    single { provideRetrofit(get()) }

    single { provideApiService(get()) }

    single { provideNetworkHelper(androidContext()) }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

fun providesBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

private fun provideRetrofit(BASE_URL: String): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)