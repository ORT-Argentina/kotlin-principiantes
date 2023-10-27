package ort.tp3.cars.data.local

import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.dataclasses.CarFilterModel
import javax.inject.Inject

class CarsLocalService @Inject constructor() {
    private val logoBaseUrl1 = "https://www.carlogos.org/car-logos/"
    private val logoBaseUrl2 = "https://www.carlogos.org/logo/"

    fun getAvailableBrands(): List<BrandsModel> {
        return listOf(
            BrandsModel("Maserati", logoBaseUrl1 + "maserati-logo-2006-900x1200.png"),
            BrandsModel("Mercedes", logoBaseUrl2 + "Mercedes-Benz-logo-2011-1920x1080.png"),
            BrandsModel("Audi", logoBaseUrl1 + "audi-logo-2016.png"),
            BrandsModel("Renault", logoBaseUrl2 + "Renault-logo-2015-2048x2048.png"),
            BrandsModel("Porsche", logoBaseUrl1 + "porsche-logo-950x1100.png"),
            BrandsModel("Jeep", logoBaseUrl1 + "jeep-logo-1993.png"),
            BrandsModel("BMW", logoBaseUrl1 + "bmw-logo-2020-gray-download.png"),
        )
    }

    suspend fun getAvailableFilters(): List<CarFilterModel> {
        return listOf(
            CarFilterModel("NAFTA", "gas", "#FFCC00", R.drawable.nafta),
            CarFilterModel("DIESEL", "diesel", "#3330E5", R.drawable.diesel),
            CarFilterModel("ELÉCTRICO", "electricity", "#04D9FF", R.drawable.electrico),
        )
    }
}
