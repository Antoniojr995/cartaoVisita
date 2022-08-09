package com.dio.cartaodevisita.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDAO {
    @Query("SELECT * FROM Card")
    fun getAll(): LiveData<List<Card>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCard(card: Card)
}