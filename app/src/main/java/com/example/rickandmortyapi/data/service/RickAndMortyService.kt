package com.example.rickandmortyapi.data.service

import com.example.rickandmortyapi.data.model.DataTDO
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    suspend fun character():Response<DataTDO>
}