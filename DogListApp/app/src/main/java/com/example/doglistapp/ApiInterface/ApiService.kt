package com.example.doglistapp.ApiInterface

import com.example.doglistapp.DogsModel.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getDogsByBreed(@Url url:String):Response<DogsResponse>
}