package com.example.rickandmortyapi.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.ActivityMainBinding
import com.example.rickandmortyapi.ui.main.adapter.Adapter
import com.example.rickandmortyapi.ui.random.RandomActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    private val viewModelMain by viewModels<ViewModelMain>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,RandomActivity::class.java))
        }
    }


    private fun initViewModel() {
        viewModelMain.characterLiveData.observe(this) {
            adapter.updateList(it)
        }

        viewModelMain.getCharacter(applicationContext)
    }

    private fun initAdapter() {
        adapter = Adapter(emptyList())
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        binding.rvCharacter.adapter = adapter
    }
}