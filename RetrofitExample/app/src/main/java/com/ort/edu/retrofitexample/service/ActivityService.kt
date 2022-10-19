package com.ort.edu.retrofitexample.service

import com.ort.edu.retrofitexample.model.Activity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ActivityService {

    @GET("activity")
    fun getActivity(@Header("api_key") apiKey: String): Call<Activity>
}