package com.example.simulacros.domain

import com.example.simulacros.data.DogRepository
import com.example.simulacros.domain.model.Dog
import javax.inject.Inject

class GetDogListUseCase @Inject constructor(private val repository: DogRepository) {

    suspend operator fun invoke(): List<Dog>? {
        val dogs = repository.getAllDogsFromDatabase()
        if (!dogs.isNullOrEmpty()) {
            return dogs
        }
        return null
    }
}