package ort.tp3.cars.dataclasses

import com.google.gson.annotations.SerializedName
import ort.tp3.cars.helpers.*

private const val logoBaseUrl1 = "https://www.carlogos.org/car-logos/"
private const val logoBaseUrl2 = "https://www.carlogos.org/logo/"


data class CarModel(
    val drive: String,
    @SerializedName("fuel_type") val fuelType: String,
    val make: String,
    val model: String,
    val transmission: String?,
    val year: Int
) {
    fun getConvertedTransmission(): String {
        return when (val transmissionType = Transmission.fromString(transmission)) {
            is Transmission.Manual -> "Manual"
            is Transmission.Automatic -> "Automatic"
            is Transmission.Other -> transmissionType.value
        }
    }

    fun getConvertedDrive(): String {
        return when (val driveType = Drive.fromString(drive)) {
            is Drive.FrontWheelDrive -> "Front-Wheel drive"
            is Drive.RearWheelDrive -> "Rear-Wheel drive"
            is Drive.AllWheelDrive -> "All-Wheel drive"
            is Drive.FourWheelDrive -> "Four-Wheel drive"
            is Drive.Other -> driveType.value
        }
    }

    fun getConvertedFuelType(): String {
        return when (val fuelTypeValue = FuelType.fromString(fuelType)) {
            is FuelType.Gas -> "Gas"
            is FuelType.Diesel -> "Diesel"
            is FuelType.Electricity -> "Electric"
            is FuelType.Other -> fuelTypeValue.value
        }
    }

    fun getConvertedMake(): String {
        return when (val brandValue = Brand.fromString(make)) {
            is Brand.Maserati -> "Maserati"
            is Brand.Mercedes -> "Mercedes Benz"
            is Brand.Audi -> "Audi"
            is Brand.Renault -> "Renault"
            is Brand.Porsche -> "Porsche"
            is Brand.Jeep -> "Jeep"
            is Brand.BMW -> "BMW"
            is Brand.Honda -> "Honda"
            is Brand.Kia -> "Kia"
            is Brand.Other -> brandValue.value.substring(0, 1).uppercase() + brandValue.value.substring(1).lowercase()
        }
    }

    fun getMakerLogo(): String {
        return when (val brandValue = Brand.fromString(make)) {
            is Brand.Maserati -> logoBaseUrl1 + "maserati-logo-2006-900x1200.png"
            is Brand.Mercedes -> logoBaseUrl2 + "Mercedes-Benz-logo-2011-1920x1080.png"
            is Brand.Audi -> logoBaseUrl1 + "audi-logo-2016.png"
            is Brand.Renault -> logoBaseUrl2 + "Renault-logo-2015-2048x2048.png"
            is Brand.Porsche -> logoBaseUrl1 + "porsche-logo-950x1100.png"
            is Brand.Jeep -> logoBaseUrl1 + "jeep-logo-1993.png"
            is Brand.BMW -> logoBaseUrl1 + "bmw-logo-2020-gray-download.png"
            is Brand.Honda -> logoBaseUrl1 + "honda-logo-1700x1150.png"
            is Brand.Kia -> logoBaseUrl2 + "Kia-logo-2560x1440.png"
            is Brand.Other -> "https://shorturl.at/DGV08"
        }
    }
}
