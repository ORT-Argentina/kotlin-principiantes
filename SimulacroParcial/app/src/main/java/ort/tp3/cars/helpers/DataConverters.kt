package ort.tp3.cars.helpers

import java.util.Locale

sealed class Transmission {
    object Manual : Transmission()
    object Automatic : Transmission()
    data class Other(val value: String) : Transmission()

    companion object {
        fun fromString(value: String?): Transmission {
            return if (value != null) {
                when (value.lowercase(Locale.ROOT)) {
                    "m" -> Manual
                    "a" -> Automatic
                    else -> Other(value)
                }
            } else {
                Other("")
            }
        }
    }
}

sealed class Drive {
    object FrontWheelDrive : Drive()
    object RearWheelDrive : Drive()
    object AllWheelDrive : Drive()
    object FourWheelDrive : Drive()
    data class Other(val value: String) : Drive()

    companion object {
        fun fromString(value: String?): Drive {
            return if (value != null) {
                when (value.lowercase(Locale.ROOT)) {
                    "fwd" -> FrontWheelDrive
                    "rwd" -> RearWheelDrive
                    "awd" -> AllWheelDrive
                    "4wd" -> FourWheelDrive
                    else -> Other(value)
                }
            } else {
                Other("")
            }
        }
    }
}

sealed class FuelType {
    object Gas : FuelType()
    object Diesel : FuelType()
    object Electricity : FuelType()
    data class Other(val value: String) : FuelType()

    companion object {
        fun fromString(value: String?): FuelType {
            return if (value != null) {
                when (value.lowercase(Locale.ROOT)) {
                    "gas" -> Gas
                    "diesel" -> Diesel
                    "electricity" -> Electricity
                    else -> Other(value)
                }
            } else {
                Other("")
            }
        }
    }
}

sealed class Brand {
    object Maserati : Brand()
    object Mercedes : Brand()
    object Audi : Brand()
    object Renault : Brand()
    object Porsche : Brand()
    object Jeep : Brand()
    object BMW : Brand()

    object Honda : Brand()

    object Kia : Brand()
    data class Other(val value: String) : Brand()

    companion object {
        fun fromString(value: String): Brand {
            return when (value.lowercase(Locale.ROOT)) {
                "maserati" -> Maserati
                "mercedes-benz" -> Mercedes
                "audi" -> Audi
                "renault" -> Renault
                "porsche" -> Porsche
                "jeep" -> Jeep
                "bmw" -> BMW
                "honda" -> Honda
                "kia" -> Kia
                else -> Other(value)
            }
        }
    }
}