package com.example.splashscreenv2.entities

import android.os.Parcel
import android.os.Parcelable

class Alumno(nombre: String?, edad: Int?, curso: String?) : Parcelable {
    var nombre: String = ""

    var curso: String = ""

    var edad: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    init {
        this.nombre = nombre!!
        this.curso = curso!!
        this.edad = edad!!
    }

    class Constants {
        companion object {
            val cursoA = "A"
            val cursoB = "B"
            val cursoC = "C"
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(curso)
        parcel.writeInt(edad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alumno> {
        override fun createFromParcel(parcel: Parcel): Alumno {
            return Alumno(parcel)
        }

        override fun newArray(size: Int): Array<Alumno?> {
            return arrayOfNulls(size)
        }
    }
}