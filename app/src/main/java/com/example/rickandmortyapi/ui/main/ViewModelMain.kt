package com.example.rickandmortyapi.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.data.model.DataTDO
import com.example.rickandmortyapi.repositories.RickAndMortyRepository
import com.example.rickandmortyapi.repositories.model.RickAndMortyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelMain:ViewModel() {

    private var repository = RickAndMortyRepository()
    var characterLiveData = MutableLiveData<List<RickAndMortyModel>>()

    fun getCharacter(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            characterLiveData.postValue( repository.getCharacter(context))
        }
    }


}