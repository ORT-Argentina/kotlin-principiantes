package com.ort.roomdatabaseexample.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Customer {

    @PrimaryKey
    val uid: Int = 0

    @ColumnInfo(name = "first_name") val firstName: String? = null

    @ColumnInfo(name = "last_name") val lastName: String? = null

}