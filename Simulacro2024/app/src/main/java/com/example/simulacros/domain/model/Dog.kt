package com.example.simulacros.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.example.simulacros.data.database.entities.DogEntity

data class Dog(
    var name:String,
    var breed:String,
    var subBreed:String,
    var age:Int,
    var image: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(breed)
        parcel.writeString(subBreed)
        parcel.writeInt(age)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }
}

fun DogEntity.toDomain() = Dog(name, breed, subBreed, age, image)