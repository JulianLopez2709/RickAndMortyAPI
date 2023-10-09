package com.example.rickandmortyapi.ui.random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityRandomBinding

class RandomActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRandomBinding
    private val randomViewModel: RandomViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomViewModel.onCreate(applicationContext)

        initViewModel()
        initListener()
    }

    private fun initListener() {
        binding.idLayout.setOnClickListener{
            randomViewModel.getCharacterFromDB(applicationContext)
        }
    }

    private fun initViewModel() {
        randomViewModel.characterLiveData.observe(this){
            println(it)

            Glide
                .with(applicationContext)
                .load(it.img)
                .into(binding.imFoto)

            binding.tvState.text = "${it.status} - ${it.species}"
            binding.tvName.text = it.name
            binding.tvLocation.text = it.location
            binding.tvOrigin.text = it.origin
        }
    }


}