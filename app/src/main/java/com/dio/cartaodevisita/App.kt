package com.dio.cartaodevisita

import android.app.Application
import com.dio.cartaodevisita.data.CardDB
import com.dio.cartaodevisita.data.CardRepository

class App : Application(){
    private val db by lazy {
        CardDB.getDB(this)
    }
    val cardRepository by lazy {
        CardRepository(db.cardDao())
    }
}
