package com.dio.cartaodevisita.ia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dio.cartaodevisita.data.Card
import com.dio.cartaodevisita.databinding.CardsBinding

class CardAdapter: ListAdapter<Card, CardAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare: (View) -> Unit = {

    }
    inner class ViewHolder(private val binding: CardsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Card){
            binding.email.text = item.email
            binding.nome.text = item.nome
            binding.tel.text = item.tel
            binding.empresa.text = item.empresa
            binding.bg.setBackgroundColor(item.cor)
            binding.cv.setOnClickListener {
                listenerShare(it)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardsBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<Card>() {

    //2
    override fun areItemsTheSame(oldItem: Card, newItem: Card) =
        oldItem.id == newItem.id

    //3
    override fun areContentsTheSame(oldItem: Card, newItem: Card) =
        oldItem == newItem
}
