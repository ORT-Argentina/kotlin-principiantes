package com.ort.edu.retrofitexample.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ActivityServiceApiBuilder {

    private val BASE_URL = "https://www.boredapi.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): ActivityService {
        return retrofit.create(ActivityService::class.java)
    }
}