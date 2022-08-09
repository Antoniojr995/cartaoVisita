package com.dio.cartaodevisita.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val nome:String,
    val email:String,
    val tel:String,
    val empresa:String,
    val cor:Int
){
}