package com.example.rickandmortyapi.data.network.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insetCharacter(characterEntity: List<CharacterEntity>)

    @Query("SELECT * FROM character_table")
    fun showAllCharacter():List<CharacterEntity>

    @Query("DELETE FROM character_table")
    fun deleteAllCharacter()
}