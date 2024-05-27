package com.example.simulacros.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simulacros.data.database.dao.DogDao
import com.example.simulacros.data.database.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1)
abstract class DogDatabase: RoomDatabase() {

    abstract fun getDogDao():DogDao

}