package ar.edu.ort.requestexamples.interfaces

import ar.edu.ort.requestexamples.data.RespuestaMarvel
import ar.edu.ort.requestexamples.entities.MarvelCharacter
import ar.edu.ort.requestexamples.entities.MarvelComic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface facebookAPI {

    @GET("v1/public/characters")
    fun getPersonajes(
        @Query("apikey") apikey: String,
        @Query("Authorization") hash: String,
        @Query("ts") ts: String = "ort",
    ): Call<RespuestaMarvel<MarvelCharacter?>?>

    @GET("v1/public/comics")
    fun getComics(
        @Query("apikey") cualquiercosa: String,
        @Query("Authorization") hash: String,
        @Query("ts") ts: String = "ort"
    ): Call<RespuestaMarvel<MarvelComic?>?>
}