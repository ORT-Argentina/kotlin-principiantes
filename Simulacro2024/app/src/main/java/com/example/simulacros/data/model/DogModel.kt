package com.example.simulacros.data.model

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("breed") val breed: String,
    @SerializedName("sub_breed") val subBreed: String,
    @SerializedName("age") val age: Int
)