package com.example.rickandmortyapi.repositories

import android.content.Context
import com.example.rickandmortyapi.data.network.db.CharacterDao
import com.example.rickandmortyapi.data.network.db.CharacterEntity
import com.example.rickandmortyapi.data.network.db.Database
import com.example.rickandmortyapi.data.network.retrofit.RetrofitHelper
import com.example.rickandmortyapi.repositories.model.RickAndMortyModel
import com.example.rickandmortyapi.repositories.model.toDomain
import com.example.rickandmortyapi.repositories.model.toEntity

class RickAndMortyRepository {
    private var service = RetrofitHelper
    private lateinit var dao: Database

    suspend fun getCharacter(context: Context): List<RickAndMortyModel> {
        try {
            dao = Database.getDatabase(context)
            val response = service.getRetrofit().character()
            if (response.isSuccessful) {
                dao.getDao().deleteAllCharacter()
                val entity = response.body()!!.results.map { it.toEntity() }
                dao.getDao().insetCharacter(entity)
                return response.body()!!.results.map { it.toDomain() }
            }
            return getCharacterFromDB(context)
        } catch (e: Exception) {
            return getCharacterFromDB(context)
        }
    }


    suspend fun getCharacterFromDB(context: Context): List<RickAndMortyModel> {
        dao = Database.getDatabase(context)
        return dao.getDao().showAllCharacter().map { it.toDomain() }
    }
}