package ort.tp3.cars.ui.viewmodels

import ort.tp3.cars.dataclasses.CarModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ort.tp3.cars.data.CarsRepository
import ort.tp3.cars.data.network.CarsService
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carsRepository: CarsRepository,
) : ViewModel() {
    private val _filter = MutableLiveData<Map<String, String>>()
    val filter: LiveData<Map<String, String>> = _filter

    fun setFilter (filter: Map<String, String>) {
        _filter.value = filter
    }

    private val _carsList = MutableLiveData<List<CarModel>>()
    val carsList: LiveData<List<CarModel>> = _carsList

    fun setCarsList (carsList: List<CarModel>) {
        _carsList.value = carsList
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun setIsLoading (isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun onCreate() {
        viewModelScope.launch {
            setIsLoading(true)

            Log.d("CarsViewModel", "Current Filters: ${filter.value}")

            if (filter.value == null
                || filter.value?.isEmpty() == true) {
                setFilter(mapOf(
                    "year" to "2022",
                ))
            }

            try {
                val carsList = filter.value?.let { carsRepository.getCarsByFilter(it) }

                Log.d("CarsViewModel", "Cars list: $carsList")

                if (carsList != null) {
                    setCarsList(carsList)
                }
            } catch (e: Exception) {
                Log.e("CarsViewModel", "Error: ${e.message}")
            }

            setIsLoading(false)
        }
    }
    fun clear() {
        _carsList.value = emptyList()
        _filter.value = emptyMap()
    }
}
