package com.example.rickandmortyapi.data.network.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class CharacterEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val status:String,
    val species:String,
    val origin:String,
    val location:String,
    val img:String
)