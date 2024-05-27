package com.example.simulacros.data.network

import com.example.simulacros.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val service:DogApiClient) {

    suspend fun getDogs( breed: String): List<DogModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getImagesByBreed(breed)
            response.body() ?: emptyList()
        }
    }

}