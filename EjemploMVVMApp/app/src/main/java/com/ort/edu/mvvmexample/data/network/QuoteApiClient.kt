package com.ort.edu.mvvmexample.data.network

import com.ort.edu.mvvmexample.data.model.QuoteModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/v1/quotes")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}