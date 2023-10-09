package com.example.rickandmortyapi.ui.main.adapter

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ItemChatacterBinding
import com.example.rickandmortyapi.repositories.model.RickAndMortyModel

class ViewHolderAdapter(private val binding: ItemChatacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RickAndMortyModel) {
        Glide
            .with(binding.root)
            .load(item.img)
            .into(binding.imageView)
        val statusAndSpecies = "${item.status} - ${item.species}"
        binding.tvName.text = item.name
        binding.tvLocation.text = item.location
        binding.tvOrigin.text = item.origin
        binding.tvStatusAndSpecie.text = statusAndSpecies

        when (item.status) {
            "Alive" -> {
                binding.imState.setColorFilter(binding.root.context.resources.getColor(R.color.green))
            }
            "Dead"-> {
                binding.imState.setColorFilter(binding.root.context.resources.getColor(R.color.red))
            }
            else -> {
                binding.imState.setColorFilter(binding.root.context.resources.getColor(R.color.text_color))
            }
        }

    }

}
