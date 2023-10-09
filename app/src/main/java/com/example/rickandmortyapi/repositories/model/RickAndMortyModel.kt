package com.example.rickandmortyapi.repositories.model

import com.example.rickandmortyapi.data.model.DataTDO
import com.example.rickandmortyapi.data.model.Result
import com.example.rickandmortyapi.data.network.db.CharacterEntity

data class RickAndMortyModel(
    val name:String,
    val status:String,
    val species:String,
    val origin:String,
    val location:String,
    val img:String
)

fun Result.toDomain():RickAndMortyModel{
    return RickAndMortyModel(
        name = name,
        status = status,
        species = species,
        origin = origin.name,
        location = location.name,
        img = image
    )
}

fun Result.toEntity():CharacterEntity{
    return CharacterEntity(
        name = name,
        status = status,
        species = species,
        origin = origin.name,
        location = location.name,
        img = image
    )
}

fun CharacterEntity.toDomain():RickAndMortyModel{
    return RickAndMortyModel(
        name = name,
        status = status,
        species = species,
        origin = origin,
        location = location,
        img = img
    )
}





