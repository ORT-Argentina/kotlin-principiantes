package com.ort.roomdatabaseexample.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User (  id : Int, name : String , email : String, avatar: String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "email")
    var email : String

    @ColumnInfo(name = "avatar")
    var avatar : String

    init {
        this.id = id
        this.name = name
        this.email = email
        this.avatar = avatar
    }
}