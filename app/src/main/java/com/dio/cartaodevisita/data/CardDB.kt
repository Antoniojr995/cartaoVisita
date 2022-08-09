package com.dio.cartaodevisita.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Card::class], version = 1)
abstract class CardDB : RoomDatabase() {
    abstract fun cardDao() : CardDAO
    companion object{
        private var INSTANCE:CardDB? = null
        fun getDB(context: Context):CardDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardDB::class.java,
                    "cardDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}