package com.example.rickandmortyapi.data.model

import com.example.rickandmortyapi.repositories.model.RickAndMortyModel

data class DataTDO(
    val info: Info,
    val results: List<Result>
)

