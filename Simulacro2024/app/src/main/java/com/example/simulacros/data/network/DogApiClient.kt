package com.example.simulacros.data.network

import com.example.simulacros.data.model.DogModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiClient {
    @GET("/api/breed/{breed}/images")
    suspend fun getImagesByBreed( @Path("breed") breed:String ): Response<List<DogModel>>

    @GET("/v1/quotes")
    suspend fun getQuote(): Response<DogModel>
}