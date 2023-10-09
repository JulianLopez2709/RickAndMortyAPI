package com.example.rickandmortyapi.data.network.retrofit

import com.example.rickandmortyapi.data.other.Constants
import com.example.rickandmortyapi.data.service.RickAndMortyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getRetrofit():RickAndMortyService{
        return retrofit.create(RickAndMortyService::class.java)
    }
}