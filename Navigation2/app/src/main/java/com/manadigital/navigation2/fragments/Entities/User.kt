package com.manadigital.navigation2.fragments.Entities

import android.os.Parcel
import android.os.Parcelable

class User(email: String, password: String) : Parcelable {
    var email: String

    var password: String

    init {
        this.email = email
        this.password = password
    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(email)
        writeString(password)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}