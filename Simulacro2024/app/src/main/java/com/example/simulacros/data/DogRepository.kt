package com.example.simulacros.data

import com.example.simulacros.data.database.dao.DogDao
import com.example.simulacros.data.database.entities.DogEntity
import com.example.simulacros.data.network.DogService
import com.example.simulacros.domain.model.Dog
import com.example.simulacros.domain.model.toDomain
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val remote: DogService,
    private val dogDao: DogDao
) {
    suspend fun getAllDogsFromDatabase():List<Dog>{
        val response: List<DogEntity> = dogDao.getAllDogs()
        return response.map { it.toDomain() }
    }

    suspend fun insertDogs(dogs:List<DogEntity>){
        dogDao.insertAll(dogs)
    }

    suspend fun clearDogs(){
        dogDao.deleteAllDogs()
    }
}