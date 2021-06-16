package com.manadigital.recyclerview1.entities

import android.os.Parcel
import android.os.Parcelable


class Mascota(nombre: String, tipo: String, raza: String, edad: Int, urlImage: String) :
    Parcelable {
    var nombre: String

    var tipo: String

    var raza: String

    var edad: Int = 0

    var urlImage: String

    constructor() : this("","","",0,"")

    class Constants {
        companion object {
            val typeGato = "GATO"
            val typePerro = "PERRO"
        }
    }

    init {
        this.nombre = nombre!!
        this.tipo = tipo!!
        this.raza = raza!!
        this.edad = edad!!
        this.urlImage = urlImage!!
    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readInt(),
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(nombre)
        writeString(tipo)
        writeString(raza)
        writeInt(edad)
        writeString(urlImage)
    }

    override fun toString(): String {
        return "Mascota(nombre='$nombre', tipo='$tipo', raza='$raza', edad=$edad, urlImage='$urlImage')"
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Mascota> = object : Parcelable.Creator<Mascota> {
            override fun createFromParcel(source: Parcel): Mascota = Mascota(source)
            override fun newArray(size: Int): Array<Mascota?> = arrayOfNulls(size)
        }
    }
}