package com.example.rickandmortyapi.ui.random

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.repositories.RickAndMortyRepository
import com.example.rickandmortyapi.repositories.model.RickAndMortyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomViewModel :ViewModel(){

    var repository = RickAndMortyRepository()
    var characterLiveData = MutableLiveData<RickAndMortyModel>()

    fun onCreate(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val characters = repository.getCharacterFromDB(context)

            if (characters.isNotEmpty()) {
                characterLiveData.postValue(characters[0])
            }
        }
    }

    fun getCharacterFromDB(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val characters = repository.getCharacterFromDB(context)

            if (characters.isNotEmpty()) {
                val randomNumber = (characters.indices).random()
                characterLiveData.postValue(characters[randomNumber])
            }
        }
    }
}