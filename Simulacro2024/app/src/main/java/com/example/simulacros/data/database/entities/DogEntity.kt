package com.example.simulacros.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simulacros.domain.model.Dog

@Entity(tableName = "dogs")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "sub_breed") val subBreed: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "image") val image: String,
)


fun Dog.toDatabase() = DogEntity(name = name, breed = breed, subBreed = subBreed, age = age, image = image)