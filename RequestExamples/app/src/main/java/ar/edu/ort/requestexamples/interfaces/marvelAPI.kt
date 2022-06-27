package ar.edu.ort.requestexamples.interfaces

import ar.edu.ort.requestexamples.data.CharacterResponse
import ar.edu.ort.requestexamples.data.MarvelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.lang.System.*

interface marvelAPI {

    @GET("v1/public/characters")
    fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String = "ort",
    ): Call<MarvelResponse<CharacterResponse?>?>?
}