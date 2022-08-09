package com.dio.cartaodevisita.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardRepository(private val dao: CardDAO) {
    fun add(card: Card) = runBlocking {
        launch(Dispatchers.IO){
            dao.addCard(card)
        }
    }
    fun getAll() = dao.getAll()
}