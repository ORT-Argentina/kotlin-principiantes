package ar.edu.ort.requestexamples.interfaces

import ar.edu.ort.requestexamples.entities.Hero
import retrofit2.Call
import retrofit2.http.GET

interface superheroAPI {
    @GET("marvel")
    fun getHeroes(): Call<List<Hero?>?>?
}