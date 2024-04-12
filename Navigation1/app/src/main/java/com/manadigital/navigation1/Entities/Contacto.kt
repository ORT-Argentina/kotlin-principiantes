package com.manadigital.navigation1.Entities

import android.os.Parcel
import android.os.Parcelable

class Contacto (nombre: String?, telefono: String?, email: String?, direccion: String?, foto: String? ): Parcelable {

    var nombre: String?
    var telefono: String?
    var email: String?
    var direccion: String?
    var foto: String?

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    init{
        this.nombre = nombre
        this.telefono = telefono
        this.email = email
        this.direccion = direccion
        this.foto = foto
    }

    override fun toString(): String {
        return "Contacto(nombre='$nombre', telefono='$telefono', email='$email', direccion='$direccion', foto='$foto')"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(telefono)
        parcel.writeString(email)
        parcel.writeString(direccion)
        parcel.writeString(foto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }

        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }

}