package com.example.rickandmortyapi.data.network.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CharacterEntity::class],
    version = 1
)
abstract class Database():RoomDatabase() {
    abstract fun getDao():CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: com.example.rickandmortyapi.data.network.db.Database? = null

        fun getDatabase(context: Context): com.example.rickandmortyapi.data.network.db.Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.rickandmortyapi.data.network.db.Database::class.java,
                    "rickCharacterDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}