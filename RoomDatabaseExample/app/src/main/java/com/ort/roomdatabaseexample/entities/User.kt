package com.ort.roomdatabaseexample.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User (  id : Int, name : String , email : String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "email")
    var email : String


    init {
        this.id = id
        this.name = name
        this.email = email

    }
}