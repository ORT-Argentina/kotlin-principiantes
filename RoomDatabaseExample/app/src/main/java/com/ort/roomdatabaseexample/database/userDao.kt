package com.ort.roomdatabaseexample.database

import androidx.room.*
import com.ort.roomdatabaseexample.entities.User

@Dao
interface userDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: User?)

    @Update
    fun updatePerson(user: User?)

    @Delete
    fun delete(user: User?)

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllPersons(): MutableList<User?>?

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadPersonById(id: Int): User?

}