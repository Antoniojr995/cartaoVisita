package com.dio.cartaodevisita.ia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dio.cartaodevisita.data.Card
import com.dio.cartaodevisita.data.CardRepository

class CardViewModel(private val cardRepository: CardRepository):ViewModel() {
    fun add(card: Card){
        cardRepository.add(card)
    }
    fun getAll():LiveData<List<Card>>{
        return cardRepository.getAll()
    }
}
class CardViewModelFactory(private val cardRepository: CardRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardViewModel::class.java)){
            @Suppress("UNCHECKED_TASK")
            return CardViewModel(cardRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}