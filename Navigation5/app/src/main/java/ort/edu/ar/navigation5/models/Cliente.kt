package ort.edu.ar.navigation5.models

import java.io.Serializable

class Cliente (nombre: String, edad: Int) : Serializable {
    var nombre: String = ""
    var edad: Int = 0

    init {
        this.nombre = nombre
        this.edad = edad
    }
}