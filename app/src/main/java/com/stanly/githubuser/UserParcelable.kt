package com.stanly.githubuser

import android.os.Parcel
import android.os.Parcelable

data class UserParcelable(
    val name: String?,
    val location: String?,
    val avatar: Int?,
    var username: String?,
    var repository: String?,
    var company: String?,
    var followers: String?,
    var following: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(location)
        parcel.writeValue(avatar)
        parcel.writeString(username)
        parcel.writeString(repository)
        parcel.writeString(company)
        parcel.writeString(followers)
        parcel.writeString(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: Parcel): UserParcelable {
            return UserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
