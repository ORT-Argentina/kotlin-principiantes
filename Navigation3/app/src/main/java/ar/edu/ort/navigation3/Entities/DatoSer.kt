package ar.edu.ort.navigation3.Entities

import java.io.Serializable

class DatoSer (nombre: String = "") : Serializable {
    var nombre: String = ""

    init {
        this.nombre = nombre
    }

}