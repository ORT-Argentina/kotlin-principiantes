package com.manadigital.recyclerview1.entities

import android.os.Parcel
import android.os.Parcelable


class Contacto(nombre: String?, edad: Int?, curso: String?) {
    var nombre: String = ""

    var curso: String = ""

    var edad: Int = 0

    var urlImage: String = ""

    class Constants {
        companion object {
            val cursoA = "A"
            val cursoB = "B"
            val cursoC = "C"
        }
    }

    init {
        this.nombre = nombre!!
        this.curso = curso!!
        this.edad = edad!!
        this.urlImage = urlImage!!
    }


}
