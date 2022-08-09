package com.dio.cartaodevisita.ia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dio.cartaodevisita.App
import com.dio.cartaodevisita.R
import com.dio.cartaodevisita.data.Card
import com.dio.cartaodevisita.databinding.ActivityAddBinding

class Addctivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAddBinding.inflate(layoutInflater)
    }
    private var colorView: View? = null
    private var red = 0
    private var green = 0
    private var blue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listeners()
    }
    private val cardViewModel:CardViewModel by viewModels{
        CardViewModelFactory((application as App).cardRepository)
    }
    private fun listeners(){
        colorView = binding.cor
        val sbred = binding.red
        val sbgreen = binding.green
        val sbblue = binding.blue
        sbred.setOnSeekBarChangeListener(mudanca)
        sbgreen.setOnSeekBarChangeListener(mudanca)
        sbblue.setOnSeekBarChangeListener(mudanca)
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.addBtn.setOnClickListener {
            val card = Card(
                nome = binding.addNomeInput.text.toString(),
                email = binding.addEmailInput.text.toString(),
                tel = binding.addTelInput.text.toString(),
                empresa = binding.addEmpresaInput.text.toString(),
                cor = Color.rgb(red,green,blue)
            )
            cardViewModel.add(card)
            Toast.makeText(this, R.string.ok, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    private val mudanca: SeekBar.OnSeekBarChangeListener = object :
        SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(
            seekBar: SeekBar,
            progress: Int,
            fromUser: Boolean
        ) {
            when (seekBar.id) {
                binding.red.id -> {
                    red = binding.red.progress
                }
                binding.green.id -> {
                    green = binding.green.progress
                }
                binding.blue.id -> {
                    blue = binding.blue.progress
                }
            }
            val color:Int = Color.rgb(red, green, blue)
            colorView?.setBackgroundColor(color)
        }
        override fun onStartTrackingTouch(p0: SeekBar?) {
        }
        override fun onStopTrackingTouch(p0: SeekBar?) {
        }
    }
}