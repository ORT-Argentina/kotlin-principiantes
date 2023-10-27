package ort.tp3.cars.data

import ort.tp3.cars.data.local.CarsLocalService
import ort.tp3.cars.data.network.CarsService
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.dataclasses.CarFilterModel
import ort.tp3.cars.dataclasses.CarModel
import javax.inject.Inject

class CarsRepository @Inject constructor(
    private val remote: CarsService,
    private val local: CarsLocalService
) {
    suspend fun getCarsByFilter(filters: Map<String, String>): List<CarModel> {
        return remote.getCarsByFilter(filters)
    }

    suspend fun getAvailableBrands(): List<BrandsModel> {
        return local.getAvailableBrands()
    }

    suspend fun getAvailableFilters(): List<CarFilterModel> {
        return local.getAvailableFilters()
    }
}