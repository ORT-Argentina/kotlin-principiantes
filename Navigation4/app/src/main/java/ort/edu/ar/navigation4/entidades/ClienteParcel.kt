package ort.edu.ar.navigation4.entidades

import android.os.Parcel
import android.os.Parcelable

class ClienteParcel(nombre: String): android.os.Parcelable {
    var nombre: String = ""

    init {
        this.nombre = nombre
    }

    constructor(parcel: Parcel) : this(parcel.readString().toString())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ClienteParcel> {
        override fun createFromParcel(parcel: Parcel): ClienteParcel {
            return ClienteParcel(parcel)
        }

        override fun newArray(size: Int): Array<ClienteParcel?> {
            return arrayOfNulls(size)
        }
    }
}