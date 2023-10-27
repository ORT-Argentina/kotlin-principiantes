package com.ort.roomdatabaseexample.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ort.roomdatabaseexample.entities.Customer

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun getAll(): List<Customer>

    @Insert
    fun insertAll(vararg users: Customer)

    @Delete
    fun delete(user: Customer)
}
