package com.ort.edu.retrofitexample.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ActivityServiceApiBuilder {

    private val BASE_URL = "https://pokeapi.co/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }
}