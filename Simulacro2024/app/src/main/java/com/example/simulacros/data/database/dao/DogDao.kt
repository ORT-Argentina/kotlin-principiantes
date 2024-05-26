package com.example.simulacros.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simulacros.data.database.entities.DogEntity

@Dao
interface DogDao {

    @Query("SELECT * FROM dogs ORDER BY name DESC")
    suspend fun getAllDogs():List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<DogEntity>)

    @Query("DELETE FROM dogs")
    suspend fun deleteAllDogs()
}