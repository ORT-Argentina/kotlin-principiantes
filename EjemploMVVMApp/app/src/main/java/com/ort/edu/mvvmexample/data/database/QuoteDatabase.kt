package com.ort.edu.mvvmexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ort.edu.mvvmexample.data.database.dao.QuoteDao
import com.ort.edu.mvvmexample.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 4)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao

}