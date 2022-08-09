package com.dio.cartaodevisita.ia

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dio.cartaodevisita.App
import com.dio.cartaodevisita.databinding.ActivityMainBinding
import com.dio.cartaodevisita.ia.adapter.CardAdapter
import com.dio.cartaodevisita.utul.Image.Companion.share



class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val cardViewModel:CardViewModel by viewModels {
        CardViewModelFactory((application as App).cardRepository)
    }
    private val adapter by lazy {
        CardAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.cardList.adapter = adapter
        getAllCard()
        listeners()
    }
    private fun listeners(){
        binding.add.setOnClickListener {
            val intent = Intent(this@MainActivity,Addctivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {
            share(this,it)
        }
    }

    private fun getAllCard(){
        cardViewModel.getAll().observe(this) { cards ->
            adapter.submitList(cards)
        }
    }
}