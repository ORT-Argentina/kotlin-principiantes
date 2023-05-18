package com.ort.edu.retrofitexample.service

import com.ort.edu.retrofitexample.model.Activity
import com.ort.edu.retrofitexample.model.Pokemon
import com.ort.edu.retrofitexample.model.PaginateResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("api/v2/pokemon")
    fun getPokemon(): Call<PaginateResponse<Pokemon>>

    @GET("api/v2/ability")
    fun getPokemonAbility(): Call<PaginateResponse<Activity>>

}