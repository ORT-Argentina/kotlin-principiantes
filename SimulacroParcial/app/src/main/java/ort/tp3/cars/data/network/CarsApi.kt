package ort.tp3.cars.data.network

import ort.tp3.cars.dataclasses.CarModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CarsApi {
    @GET("/v1/cars")
    suspend fun getCarsByFilter(
        @QueryMap filters: Map<String, String>
    ): Response<List<CarModel>>
}