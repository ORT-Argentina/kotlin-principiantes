package ort.edu.ar.navigation5.models

import android.os.Parcel
import android.os.Parcelable

class Numero( origen: Int, destino: Int) : Parcelable {
    var origen: Int = 0
    var destino: Int = 0

    constructor(parcel: Parcel) : this(
        TODO("origen"),
        TODO("destino")
    ) {
        origen = parcel.readInt()
        destino = parcel.readInt()
    }

    init {
        this.origen = origen
        this.destino = destino
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(origen)
        parcel.writeInt(destino)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Numero> {
        override fun createFromParcel(parcel: Parcel): Numero {
            return Numero(parcel)
        }

        override fun newArray(size: Int): Array<Numero?> {
            return arrayOfNulls(size)
        }
    }
}