package com.manadigital.navigation1.Entities

import android.os.Parcel
import android.os.Parcelable

class Cosa (untexto: String) : Parcelable {

    var untexto: String

    constructor(parcel: Parcel) : this( parcel.readString().toString() )

    init{
        this.untexto = untexto
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(untexto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cosa> {
        override fun createFromParcel(parcel: Parcel): Cosa {
            return Cosa(parcel)
        }

        override fun newArray(size: Int): Array<Cosa?> {
            return arrayOfNulls(size)
        }
    }
}