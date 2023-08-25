package com.ort.edu.retrofitexample.model

import com.google.gson.annotations.SerializedName

data class Activity(
    val type: String?,
    val participants: Int?,
    val price: Double?
)
