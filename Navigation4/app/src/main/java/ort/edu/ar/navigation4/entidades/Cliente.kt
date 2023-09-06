package ort.edu.ar.navigation4.entidades

import java.io.Serializable

class Cliente (nombre: String = "", edad: Int) : Serializable {
    var nombre: String = ""
    var edad: Int

    init {
        this.nombre = nombre
        this.edad = edad
    }
}