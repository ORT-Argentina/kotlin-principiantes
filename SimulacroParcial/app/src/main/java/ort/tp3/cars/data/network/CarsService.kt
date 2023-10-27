package ort.tp3.cars.data.network

import ort.tp3.cars.dataclasses.CarModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsService @Inject constructor(
    private val api: CarsApi
) {
    suspend fun getCarsByFilter(filters: Map<String, String>): List<CarModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCarsByFilter(filters)
            response.body() ?: emptyList()
        }
    }
}
