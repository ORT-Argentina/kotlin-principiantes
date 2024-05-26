package com.example.simulacros.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simulacros.data.DogRepository
import com.example.simulacros.data.DogRepository_Factory
import com.example.simulacros.data.database.entities.DogEntity
import com.example.simulacros.domain.GetDogListUseCase
import com.example.simulacros.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogListUseCase: GetDogListUseCase,
    private val repository: DogRepository
) : ViewModel() {

    var listDog = MutableLiveData<List<Dog>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        addDogsToList()
    }

    fun addDogsToList() {
        CoroutineScope(Dispatchers.Main).launch {
            isLoading.postValue(true)

            var result = getDogListUseCase()
            if (result.isNullOrEmpty()) {
                val dogs = ArrayList<DogEntity>()
                dogs.add(DogEntity(0, "test", "test", "test", 10, "https://images.dog.ceo/breeds/akita/512px-Ainu-Dog.jpg"))
                dogs.add(DogEntity(0, "test 1", "test 1", "test 1", 5, "https://images.dog.ceo/breeds/akita/512px-Akita_inu.jpg"))
                dogs.add(DogEntity(0, "test 2", "test 2", "test 2", 3, "https://images.dog.ceo/breeds/akita/Akina_Inu_in_Riga_1.jpg"))
                repository.insertDogs(dogs.toList())
                result = repository.getAllDogsFromDatabase()
            }

            listDog.postValue(result)
            isLoading.postValue(false)
        }
    }
}