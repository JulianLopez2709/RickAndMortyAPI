package com.example.rickandmortyapi.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemChatacterBinding
import com.example.rickandmortyapi.repositories.model.RickAndMortyModel

class Adapter(private var listCharacter:List<RickAndMortyModel>):RecyclerView.Adapter<ViewHolderAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        return ViewHolderAdapter(ItemChatacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        val item = listCharacter[position]
        holder.bind(item)
    }

    fun updateList(newList:List<RickAndMortyModel>){
        listCharacter = newList
        notifyDataSetChanged()
    }
}